package com.owl.core.model;

/**
 * Created by wanghouping on 2017/10/7.
 * 输入配置实体.
 * @author wang hou ping
 */
public class InputConfig {

    /**
     * 用户名.
     */
    private String userName;

    /**
     * 密码.
     */
    private String password;

    /**
     * ras秘钥.
     */
    private String rsaKey;

    /**
     * IP地址.
     */
    private String ip;

    /**
     * Liunx登录端口号.
     */
    private String port;

    /**
     * liunx发包路径地址.
     */
    private String liunxPath;

    /**
     * liunx包地址.
     */
    private String liunxJarPath;

    /**
     * 本地项目路径.
     */
    private String path;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRsaKey() {
        return rsaKey;
    }

    public void setRsaKey(String rsaKey) {
        this.rsaKey = rsaKey;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getLiunxPath() {
        return liunxPath;
    }

    public void setLiunxPath(String liunxPath) {
        this.liunxPath = liunxPath;
    }

    public String getLiunxJarPath() {
        return liunxJarPath;
    }

    public void setLiunxJarPath(String liunxJarPath) {
        this.liunxJarPath = liunxJarPath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
