package com.owl.maven;

import com.owl.core.enums.CmdMaven;
import com.owl.core.interfaces.IMavenLogResolve;
import com.owl.core.interfaces.IMavenProcess;
import com.owl.core.model.Config;
import com.owl.core.process.MavenProcess;
import com.owl.utils.CmdUtils;

import java.io.BufferedReader;

/**
 * Created by wanghouping on 2017/9/28.
 * Maven Deploy构建项目
 * @author wang hou ping
 */
public class DeployBuildJar extends MavenProcess implements IMavenProcess{

    @Override
    public void buildJar(Config config) throws Exception {
        CmdUtils.cmdPrintLog(config, CmdMaven.CMD_DEPLOY.toString(), new IMavenLogResolve() {
            @Override
            public void resolve(Config config, BufferedReader NormalBufferedReader, BufferedReader errorBufferedReader) {

            }
        });
    }
}
