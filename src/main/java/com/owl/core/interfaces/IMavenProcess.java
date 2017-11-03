package com.owl.core.interfaces;

import com.owl.core.model.Config;

import java.io.IOException;

/**
 * Created by wanghouping on 2017/9/28.
 * @author wang hou ping
 */
public interface IMavenProcess {

    /**
     * 构建Jar.
     * 该接口有一个抽象的层，实现有两种.
     * PackageJar 打包到本项目.
     * DeployJar 打包的Maven私服.
     */
    void buildJar(Config config) throws Exception;
}
