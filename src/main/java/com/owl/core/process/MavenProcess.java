package com.owl.core.process;

import com.owl.core.interfaces.IMavenProcess;
import com.owl.core.model.Config;

/**
 * Created by wanghouping on 2017/9/28.
 * 构建Jar抽象层.
 * @author wang hou ping
 */
public abstract class MavenProcess implements IMavenProcess{

    @Override
    public abstract void buildJar(Config config) throws Exception;
}
