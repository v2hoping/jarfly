package com.owl;

import com.alibaba.fastjson.JSON;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wanghouping on 2017/11/3.
 *
 * @author houping wang
 */
public class PsTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Pattern pattern = Pattern.compile("(?<=16318)(.*)(?=\r\n)");

    private final Pattern pattern2 = Pattern.compile("(?<=java -jar\\s)(.*)");

    @Test
    public void test() throws JSchException, IOException {
        Session session = null;
        ChannelShell channel = null;
        InputStream instream = null;
        OutputStream outstream = null;
        try{
            JSch jSch = new JSch();
            jSch.addIdentity("E:\\秘钥\\id_rsa(1)", "");
            session = jSch.getSession("centos", "172.16.120.117", 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect(15000);
            channel = (ChannelShell) session.openChannel("shell");
            channel.connect();
            //获取输入流和输出流
            instream = channel.getInputStream();
            outstream = channel.getOutputStream();
            String ps1 = "ps -ef|grep '16318'\n";
            outstream.write(ps1.getBytes());
            outstream.flush();
            Thread.sleep(1000);
            if(instream.available() >= 0) {
                byte[] bytes = new byte[instream.available()];
                int read = instream.read(bytes);
                String s = new String(bytes, 0, read, "UTF-8");
                Matcher matcher = pattern.matcher(s);
                List<String> list = new ArrayList<String>();
                while(matcher.find()) {
                    Matcher matcher1 = pattern2.matcher(matcher.group());
                    while(matcher1.find()) {
                        list.add(matcher1.group());
                    }
                }
                logger.info(s);
                logger.info(JSON.toJSONString(list));
            }
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
        }finally {
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
}
