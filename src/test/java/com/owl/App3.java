package com.owl;

import com.owl.Jarfly;

/**
 * Created by wanghouping on 2017/11/2.
 *
 * @author houping wang
 */
public class App3 {

    public static void main(String[] args) throws Exception {
        Jarfly.selector().setRsaKey("E:\\秘钥\\id_rsa(1)")
                .setUserName("centos")
                .setIp("172.16.120.117")
                .setPort("22")
                .setLiunxPath("/home/centos/springboot/demo/")
                .setPath("E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot")
                .setKillOutTime(10 * 1000)
                .setUpOutTime(10 * 1000)
                .setDubboOutTime(10 * 1000)
                .run();
    }
}
