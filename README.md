# Quick Start

#### Scene

Jarfly是一个对SpringBoot进行持续集成的应用.

其中主要包括以下几个部分:

* **Maven打包**: 提供Maven package打包集成.
* **SSH Jar上传**: 支持SFTP上传Springboot Jar包到指定目录，显示上传详情并执行.
* **服务执行**: 支持服务检测停止、服务启动、后续会加入对于Dubbo端口、日志检测以及服务异常回滚.
* **配置替换启动**: 后续加入对于关键配置检查、对不同环境下配置切换服务.(未实现)
* **基于Dubbo应用**: 支持Dubbo应用的Dubbo端口检查，自动替换服务.

环境:

* 仅支持SpringBoot项目(因为使用Jar -jar形式启动)
* 仅支持Dubbo应用(因为需要有依据Dubbo端口检查服务)
* 远程服务器为Liunx，支持SSH、SFTP协议

#### Maven Setting

目前只打包到了Maven私服上，可以下载代码后代码到本地私服使用，Maven坐标如下:

```xml
<dependency>
     <groupId>com.owl</groupId>
     <artifactId>jarfly</artifactId>
     <version>1.0.0</version>
</dependency>
```

#### Jarfly

一个实体类包装了所有入参，调用封装后的方法执行操作：
```java
Jarfly.selector().setRsaKey("E:\\秘钥\\id_rsa(1)")
             .setUserName("centos")
             .setIp("172.16.120.117")
             .setPort("22")
             .setPassword("")
             .setLiunxPath("/home/centos/springboot/demo/")
             .setPath("E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot")
             .run();
```

#### Log
维护日志、未来工作的[日志记录](./LOG.md)

