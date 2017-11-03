package com.owl;

import com.owl.check.SpringBootCheck;
import com.owl.config.ConfigProcess;
import com.owl.core.enums.CmdMaven;
import com.owl.core.interfaces.*;
import com.owl.core.model.Config;
import com.owl.core.model.Result;
import com.owl.maven.MavenGetPrintResolve;
import com.owl.ssh.SSHDefaultProcess;
import com.owl.utils.CmdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wanghouping on 2017/11/2.
 *
 * @author houping wang
 */
public class JarflyProcess {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private IMavenProcess mavenProcess = null;

    private IConfigProcess configProcess = null;

    private ISSHProcess SSHProcess = null;

    private ISpringBootCheck springBootCheck = null;

    private Config config = null;

    private JarflyProcess(JarflyBuilder jarflyBuilder) {
        this.mavenProcess = jarflyBuilder.mavenProcess;
        this.configProcess = jarflyBuilder.configProcess;
        this.SSHProcess = jarflyBuilder.SSHProcess;
        this.springBootCheck = jarflyBuilder.springBootCheck;
        this.config = jarflyBuilder.config;
    }

    public void run() throws Exception {
        //<2>构建Maven Jar，并解析获得包名、文件路径
        mavenProcess.buildJar(config);
        //<3>解析获取项目配置文件
        configProcess.fillConfig(config);
        //<3>检查配置
        Result result = configProcess.checkConfig();
        if(!result.isFlag()) {
            logger.error("[配置异常]\n" + result.getErrorMsg());
            return;
        }
        //<4>输入SSH配置
        SSHProcess.init(config);
        //<5>生成SSH通信管道
        SSHProcess.login();
        //<6>上传Liunx服务器
        SSHProcess.upload();
        //<7>停止原程序
        SSHProcess.shutDownOld();
        //<8>启动Springboot
        SSHProcess.startUp();
        //关闭流
        //TODO:实现状态检查.(服务检查+Dubbo检查，定义超时时间，规定默认时间，需手动开启)
        springBootCheck.checkRunStatus();
        logger.info("启动服务成功!");
        SSHProcess.closeAll();
    }

    public static class JarflyBuilder {

        public JarflyBuilder() {
            config = new Config();
        }

        private Config config;

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
         * Liunx登录端口号.
         */
        private String port;

        /**
         * liunx发包路径地址.
         */
        private String liunxPath;

        /**
         * 本地项目路径.
         */
        private String path;

        private long killOutTime = 10 * 1000;

        private long upOutTime = 10 * 1000;

        private long dubboOutTime = 10 * 1000;

        /**
         * Dubbo地址.
         */
        private String dubboUrl;

        /**
         * maven模式选择.
         */
        private CmdMaven cmdMaven;

        private IMavenProcess mavenProcess = null;

        private IConfigProcess configProcess = null;

        private ISSHProcess SSHProcess = null;

        private ISpringBootCheck springBootCheck = new SpringBootCheck();

        public JarflyBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public JarflyBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public JarflyBuilder setRsaKey(String rsaKey) {
            this.rsaKey = rsaKey;
            return this;
        }

        public JarflyBuilder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public JarflyBuilder setPort(String port) {
            this.port = port;
            return this;
        }

        public JarflyBuilder setLiunxPath(String liunxPath) {
            this.liunxPath = liunxPath;
            return this;
        }

        public JarflyBuilder setPath(String path) {
            this.path = path;
            return this;
        }

        public JarflyBuilder setCmdMaven(CmdMaven cmdMaven) {
            this.cmdMaven = cmdMaven;
            return this;
        }

        /**
         * 默认时间10s.
         */
        public JarflyBuilder setKillOutTime(long l) {
            this.killOutTime = l;
            return this;
        }

        /**
         * 默认时间10s.
         */
        public JarflyBuilder setUpOutTime(long l) {
            this.upOutTime = l;
            return this;
        }

        /**
         * 默认时间10s.
         */
        public JarflyBuilder setDubboOutTime(long l) {
            this.dubboOutTime = l;
            return this;
        }

        public JarflyBuilder setDubboUrl(String dubboUrl) {
            this.dubboUrl = dubboUrl;
            return this;
        }

        private JarflyProcess build() {
            this.config = buildConfig();
            this.configProcess = new ConfigProcess();
            this.SSHProcess = new SSHDefaultProcess();
            this.springBootCheck = new SpringBootCheck();
            this.mavenProcess = new IMavenProcess() {
                @Override
                public void buildJar(Config config) throws Exception {
                    if(null == cmdMaven) {
                        cmdMaven = CmdMaven.CMD_PACKAGE;
                    }
                    CmdUtils.cmdPrintLog(config, cmdMaven.toString(), new MavenGetPrintResolve());
                }
            };
            return new JarflyProcess(this);
        }

        public void run() throws Exception {
            JarflyProcess build = build();
            build.run();
        }

        private Config buildConfig() {
            config.setUserName(this.userName);
            config.setPassword(this.password);
            config.setRsaKey(this.rsaKey);
            config.setIp(this.ip);
            config.setPort(this.port);
            config.setLiunxPath(this.liunxPath);
            config.setPath(this.path);
            return config;
        }

    }
}
