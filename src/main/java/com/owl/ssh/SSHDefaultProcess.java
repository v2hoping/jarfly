package com.owl.ssh;

import com.jcraft.jsch.*;
import com.owl.core.interfaces.ISSHProcess;
import com.owl.core.model.Config;
import com.owl.core.model.Result;
import org.slf4j.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wanghouping on 2017/10/1.
 * @author wang hou pings
 */
public class SSHDefaultProcess implements ISSHProcess{

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final Pattern pattern = Pattern.compile("([0-9]+)(?=/.*)");//匹配PID号

    /**
     * 用户名.
     */
    private String userName;

    /**
     * 密码.
     */
    private String password;

    /**
     * ras秘钥.
     */
    private String rsaKey;

    /**
     * IP地址.
     */
    private String ip;

    /**
     * 端口号.
     */
    private String port;

    /**
     * liunx发包地址.
     */
    private String liunxPath;

    /**
     * 本地包地址.
     */
    private String localPath;

    /**
     * 老Jar包地址.
     */
    private String oldJarPath;

    /**
     * Dubbo端口.
     */
    private String dubboPort;

    /**
     * SSH Session会话.
     */
    private Session session;

    /**
     * SSH输入流.
     */
    private InputStream instream;

    /**
     * SSH输出流.
     */
    private OutputStream outstream;

    /**
     * 流.
     */
    private ChannelShell channel;

    @Override
    public void init(Config config) {
        this.userName = config.getUserName();
        this.password = config.getPassword();
        this.rsaKey = config.getRsaKey();
        this.ip = config.getIp();
        this.port = config.getPort();
        this.liunxPath = config.getLiunxPath() + config.getJarName();
        this.localPath = config.getJarPath();
        this.oldJarPath = config.getOldJarPath();
        this.dubboPort = config.getJarDubboPort();
    }

    @Override
    public void login() throws JSchException, IOException, SftpException {
        JSch jSch = new JSch();
        jSch.addIdentity(this.rsaKey, this.password);
        Session session = jSch.getSession(this.userName, this.ip, Integer.parseInt(this.port));
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect(15000);
        this.session = session;
        //Shell流
        channel = (ChannelShell)session.openChannel("shell");
        channel.connect();
        //获取输入流和输出流
        instream = channel.getInputStream();
        outstream = channel.getOutputStream();
        logger.info(this.userName + "用户，登录" + this.ip + "成功！");
    }

    @Override
    public void upload() throws IOException, JSchException, SftpException {
        ChannelSftp sftp = null;
        FileInputStream jarIn = null;
        try{
            File jar = new File(localPath);
            jarIn = new FileInputStream(jar);
            sftp = (ChannelSftp)session.openChannel("sftp");
            sftp.connect();
            sftp.put(jarIn, liunxPath, ChannelSftp.OVERWRITE);
        }finally {
            if(jarIn != null) {
                jarIn.close();
            }
            if(sftp != null) {
                sftp.disconnect();
            }
        }
    }

    @Override
    public void startUp() throws Exception {
        //<1>启动服务
        String springboot = "nohup java -jar %s > /dev/null 2>&1 &\n";
        String springbootCmd = String.format(springboot, liunxPath);
        outstream.write(springbootCmd.getBytes());
        outstream.flush();
        Thread.sleep(1000);
        //<2>显示Java进程
        psJava();
    }

    @Override
    public void shutDownOld() throws Exception {
        //<1>检查是否有旧服务启动
        String netstat = "sudo netstat -tunlp|grep %s\n";
        String netstatCmd = String.format(netstat, dubboPort);
        outstream.write(netstatCmd.getBytes());
        outstream.flush();
        Thread.sleep(1000);
        if (instream.available() <= 0) {
            logger.info("未检测到" + dubboPort + "Dubbo端口程序启动，准备启动Jar");
            return;
        }
        byte[] bytes = new byte[instream.available()];
        int nLen = instream.read(bytes);
        if (nLen < 0) {
            throw new Exception("network error!");
        }
        String netstatCmdRespond = new String(bytes, 0, nLen, "UTF-8");
        //<2>过滤同Dubbo端口进程的Pid
        Matcher matcher = pattern.matcher(netstatCmdRespond);
        List<String> pids = new ArrayList<String>();
        while(matcher.find()) {
            pids.add(matcher.group().trim());
        }
        if(pids.size() == 0) {
            logger.info("未检测到" + dubboPort + "Dubbo端口程序启动，准备启动Jar");
            return;
        }
        //<3>停止旧服务
        int timeOut = 10;
        for(String pid : pids) {
            logger.info("正在kill 进程" + pid);
            String kill = "sudo kill %s\n";
            String killCmd = String.format(kill, pid);
            outstream.write(killCmd.getBytes());
            outstream.flush();
            //循环检查,
            for(int i = 0; i < timeOut; i ++) {
                logger.info("检查进程" + pid + "是否终止，请等待1s...");
                Thread.sleep(1000);
                boolean b = checkOldServicePid();
                if (!b) {
                    logger.info("kill 进程" + pid + "成功！");
                    break;
                }
                if (i == 9) {
                    logger.info("进程" + pid + "检测10次后仍然运行，执行kill -9强制终止!");
                    kill9Pid(pid);
                    //强制杀死进程并结束.
                    break;
                }
                logger.info("进程" + pid + "仍在运行中...[" + i + "]");
            }
        }
    }

    /**
     * 检查旧服务是否启动，依靠Dubbo端口检查.
     * @return true 启动中  false 已停止
     * @throws Exception
     */
    private boolean checkOldServicePid() throws Exception {
        String netstat = "sudo netstat -tunlp|grep %s\n";
        String netstatCmd = String.format(netstat, dubboPort);
        outstream.write(netstatCmd.getBytes());
        outstream.flush();
        Thread.sleep(1000);
        if (instream.available() <= 0) {
            return false;
        }
        byte[] bytes = new byte[instream.available()];
        int nLen = instream.read(bytes);
        if (nLen < 0) {
            return false;
        }
        String netstatCmdRespond = new String(bytes, 0, nLen, "UTF-8");
        //<2>过滤同Dubbo端口进程的Pid
        Matcher matcher = pattern.matcher(netstatCmdRespond);
        List<String> pids = new ArrayList<String>();
        while(matcher.find()) {
            pids.add(matcher.group().trim());
        }
        return pids.size() != 0;
    }

    private void kill9Pid(String pid) throws Exception {
        String kill9 = "sudo kill -9 %s\n";
        String kill9Cmd = String.format(kill9, pid);
        outstream.write(kill9Cmd.getBytes());
        outstream.flush();
        logger.info("强制终止进程" + pid + ",请等待2s.");
        Thread.sleep(2000);
        boolean b = checkOldServicePid();
        if(b) {
            throw new Exception("进程" + pid + "强制终止失败，请检查后重试！");
        }
    }

    private void psJava() throws Exception {
        String psJava = "ps -ef|grep 'java -jar'\n";
        outstream.write(psJava.getBytes());
        outstream.flush();
        Thread.sleep(1000);
        if (instream.available() <= 0) {
            logger.info("未检测到" + dubboPort + "Dubbo端口程序启动，准备启动Jar");
            return;
        }
        byte[] bytes = new byte[instream.available()];
        int nLen = instream.read(bytes);
        if (nLen < 0) {
            throw new Exception("network error!");
        }
        String repsond = new String(bytes, 0, nLen, "UTF-8");
        logger.info("显示Java进程：");
        logger.info(repsond);
    }

    @Override
    public void rollBack() {

    }

    @Override
    public Result checkRunStatus() {
        return null;
    }

    @Override
    public void closeAll() throws IOException {
        String eixt = "eixt\n";
        outstream.write(eixt.getBytes());
        outstream.flush();
        if(instream != null) {
            instream.close();
        }
        if(outstream != null) {
            outstream.close();
        }
        if(channel != null) {
            channel.disconnect();
        }
        if(session != null) {
            session.disconnect();
        }
    }
}
