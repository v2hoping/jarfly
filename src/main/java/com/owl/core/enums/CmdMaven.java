package com.owl.core.enums;

/**
 * Created by wanghouping on 2017/9/28.
 * Maven CMD命令
 * @author wang hou ping
 */
public enum CmdMaven {

    CMD_PACKAGE("cmd /c mvn clean source:jar package -Dmaven.test.skip=true"),
    CMD_DEPLOY("cmd /c mvn clean source:jar deploy -Dmaven.test.skip=true");


    CmdMaven(String cmd) {
        this.cmd = cmd;
    }

    private String cmd;

    @Override
    public String toString() {
        return cmd;
    }
}
