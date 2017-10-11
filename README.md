Jarfly是一个对SpringBoot进行持续集成的应用.
其中主要包括以下几个部分:
* **Maven打包**: 提供Maven package打包集成.
* **SSH Jar上传**: 支持SFTP上传Springboot Jar包到指定目录并执行.
* **服务执行**: 支付服务检测停止、服务启动、后续会加入对于Dubbo端口、日志检测以及服务异常回滚.
* **配置替换启动**: 后续加入对于关键配置检查、对不同环境下配置切换服务.(未实现)

## Quick Start

#Maven Setting

目前只打包到了Maven私服上，可以下载代码后代码到本地私服使用，Maven坐标如下:

```xml
<dependency>
    <groupId>net.dongliu</groupId>
    <artifactId>requests</artifactId>
    <version>4.5.0</version>
</dependency>
```
#Jarfly

一个实体类包装了所有入参，调用封装后的方法执行操作：
```java
InputConfig inputConfig = new InputConfig();
inputConfig.setRsaKey("E:\\id_rsa");
inputConfig.setUserName("root");
inputConfig.setIp("172.0.0.1");
inputConfig.setPort("22");
inputConfig.setPassword("");
inputConfig.setLiunxPath("/home/centos/springboot/demo/");
inputConfig.setPath("E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot");
IJaflyProcess iJaflyProcess = new JaflyProcess(inputConfig);
iJaflyProcess.run();
```
