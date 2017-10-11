package com.owl.core.model;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * Created by wanghouping on 2017/9/28.
 * 配置实体.
 * //1.1解析获得Jar文件路径；Jar文件名称；Jar文件命名规则；项目端口；操作用户；对外暴露服务；
 */
public class Config {

    //***用户输入配置***

    /**
     * 用户名.
     */
    @NotBlank(message = "用户名不存在！")
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
    @NotBlank(message = "服务器IP地址不存在！")
    private String ip;

    /**
     * Liunx登录端口号.
     */
    @NotBlank(message = "服务器端口不存在！")
    private String port;

    /**
     * liunx发包地址.
     */
    @NotBlank(message = "Liunx文件路径不存在！")
    private String liunxPath;

    //***发包失败后，重新回滚Jar包位置***

    private String oldJarPath;

    //***系统读取配置***

    /**
     * 项目路径.
     */
    @NotBlank(message = "项目地址不存在！")
    private String path = "E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot";

    /**
     * 本地包路径..
     */
    @NotBlank(message = "Jar包路径不存在！")
    private String jarPath = "";

    /**
     * Jar包名称.
     */
    @NotBlank(message = "Jar包名称不存在！")
    private String jarName = "";

    /**
     * Dubbo端口.
     */
    @NotBlank(message = "Dubbo端口不存在！")
    private String jarDubboPort = "";

    /**
     * Http端口.
     */
    @NotBlank(message = "Http端口不存在！")
    private String jarHttpPort = "";

    /**
     * 所使用的配置.
     */
    @NotBlank(message = "所使用配置不存在！")
    private String include = "";

    /**
     * 操作人名称.
     */
    private String operationUser = "";

    /**
     * liunx jar包路径.
     */
    @NotBlank(message = "")
    private String liunxJarPath;

    /**
     * dubbo接口地址列表.
     */
    private List<DubboInterface> dubboServices;

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    public String getJarName() {
        return jarName;
    }

    public void setJarName(String jarName) {
        this.jarName = jarName;
    }

    public String getJarDubboPort() {
        return jarDubboPort;
    }

    public void setJarDubboPort(String jarDubboPort) {
        this.jarDubboPort = jarDubboPort;
    }

    public String getJarHttpPort() {
        return jarHttpPort;
    }

    public void setJarHttpPort(String jarHttpPort) {
        this.jarHttpPort = jarHttpPort;
    }

    public String getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }

    public List<DubboInterface> getDubboServices() {
        return dubboServices;
    }

    public void setDubboServices(List<DubboInterface> dubboServices) {
        this.dubboServices = dubboServices;
    }

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

    public String getOldJarPath() {
        return oldJarPath;
    }

    public void setOldJarPath(String oldJarPath) {
        this.oldJarPath = oldJarPath;
    }

    public String getLiunxJarPath() {
        return liunxJarPath;
    }

    public void setLiunxJarPath(String liunxJarPath) {
        this.liunxJarPath = liunxJarPath;
    }
}
