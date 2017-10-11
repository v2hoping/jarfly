package com.owl.core.process;

import com.owl.check.SpringBootCheck;
import com.owl.config.ConfigInitDefaultProcess;
import com.owl.config.ConfigProcess;
import com.owl.core.interfaces.*;
import com.owl.core.model.Config;
import com.owl.core.model.InputConfig;
import com.owl.core.model.Result;
import com.owl.input.InputConfigProcess;
import com.owl.maven.PackageBuildJar;
import com.owl.ssh.SSHDefaultProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by wanghouping on 2017/9/25.
 * 核心处理
 * @author wang hou ping
 */
public class JaflyProcess implements IJaflyProcess{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private IMavenProcess mavenProcess = new PackageBuildJar();

    private IConfigInitProcess configInitProcess = new ConfigInitDefaultProcess();

    private IConfigProcess configProcess = new ConfigProcess();

    private ISSHProcess SSHProcess = new SSHDefaultProcess();

    private ISpringBootCheck springBootCheck = new SpringBootCheck();

    private InputConfig inputConfig = null;

    private IInputConfigProcess inputConfigProcess = new InputConfigProcess();

    public JaflyProcess(InputConfig inputConfig) {
        this.inputConfig = inputConfig;
    }

    public void run() throws Exception {
        //<0>初始化全局配置
        Config config = configInitProcess.init();
        //<1>输入外部配置
        inputConfigProcess.fillInputConfig(config, inputConfig);
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
        //<9>关闭流
        SSHProcess.closeAll();
        logger.info("启动服务成功!");
    }
}
