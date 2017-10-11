package com.owl.maven;

import com.owl.core.enums.CmdMaven;
import com.owl.core.interfaces.IMavenProcess;
import com.owl.core.model.Config;
import com.owl.core.process.MavenProcess;
import com.owl.utils.CmdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wanghouping on 2017/9/28.
 * 本地构建Jar.
 * @author wang hou ping
 */
public class PackageBuildJar extends MavenProcess implements IMavenProcess{

    private static final Logger logger = LoggerFactory.getLogger(PackageBuildJar.class);

    @Override
    public void buildJar(Config config) throws Exception {
        CmdUtils.cmdPrintLog(config, CmdMaven.CMD_PACKAGE.toString(), new MavenGetPrintResolve());
    }
}
