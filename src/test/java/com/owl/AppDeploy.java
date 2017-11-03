package com.owl;

import com.owl.core.enums.CmdMaven;

/**
 * Created by wanghouping on 2017/11/3.
 *
 * @author houping wang
 */
public class AppDeploy {

    public static void main(String[] args) throws Exception {
        Jarfly.selector()
                .setRsaKey("E:\\秘钥\\id_rsa(1)")
                .setUserName("centos")
                .setIp("172.16.120.117")
                .setPort("22")
                .setPassword("")
                .setLiunxPath("/home/centos/springboot/demo/")
                .setPath("E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot")
                .run();
    }
}
