package com.owl.core.model;

/**
 * Created by wanghouping on 2017/10/1.
 * @author wang hou ping
 */
public class DubboInterface {

    private String interfaceName;

    private String version;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return interfaceName + ":" + version;
    }
}
