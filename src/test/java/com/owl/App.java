package com.owl;

import com.owl.core.interfaces.IJaflyProcess;
import com.owl.core.model.InputConfig;
import com.owl.core.process.JaflyProcess;

/**
 * Hello world!
 */
public class App 
{
    public static void main(String[] args ) throws Exception {
        InputConfig inputConfig = new InputConfig();
        inputConfig.setRsaKey("");//秘钥
        inputConfig.setUserName("");//用户名
        inputConfig.setIp("");//host地址
        inputConfig.setPort("");//端口
        inputConfig.setPassword("");//密码
        inputConfig.setLiunxPath("/home/centos/springboot/demo/");//地址
        inputConfig.setPath("E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot");//本地项目地址
        IJaflyProcess iJaflyProcess = new JaflyProcess(inputConfig);
        iJaflyProcess.run();
    }
}
