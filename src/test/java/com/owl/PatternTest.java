package com.owl;

import com.owl.core.constants.MavenC;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wanghouping on 2017/9/28.
 * 测试正则表达式.
 * @author wang hou ping
 */
public class PatternTest {

    private static final String log = "2017-10-10 13:05:52.371 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Scanning for projects... \n" +
            "2017-10-10 13:05:52.543 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:05:52.543 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Reactor Build Order: \n" +
            "2017-10-10 13:05:52.543 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:52.543 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot \n" +
            "2017-10-10 13:05:52.543 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot-Model \n" +
            "2017-10-10 13:05:52.543 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot-Interfaces \n" +
            "2017-10-10 13:05:52.543 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot-Repository \n" +
            "2017-10-10 13:05:52.543 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot-Service \n" +
            "2017-10-10 13:05:52.543 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-Web \n" +
            "2017-10-10 13:05:53.140 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]                                                                          \n" +
            "2017-10-10 13:05:53.141 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:05:53.141 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building WitParking.Demo-SpringBoot 1.0-SNAPSHOT \n" +
            "2017-10-10 13:05:53.141 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:05:53.155 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:53.155 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ WitParking.Demo-SpringBoot --- \n" +
            "2017-10-10 13:05:53.312 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:53.312 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] >>> maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot >>> \n" +
            "2017-10-10 13:05:53.313 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:53.313 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] <<< maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot <<< \n" +
            "2017-10-10 13:05:53.314 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:53.314 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot --- \n" +
            "2017-10-10 13:05:54.299 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]                                                                          \n" +
            "2017-10-10 13:05:54.299 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:05:54.300 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building WitParking.Demo-SpringBoot-Model 1.0-SNAPSHOT \n" +
            "2017-10-10 13:05:54.300 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:05:56.030 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:56.030 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ WitParking.Demo-SpringBoot-Model --- \n" +
            "2017-10-10 13:05:56.032 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Deleting E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Model\\target \n" +
            "2017-10-10 13:05:56.369 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:56.369 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] >>> maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Model >>> \n" +
            "2017-10-10 13:05:56.371 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:56.371 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] <<< maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Model <<< \n" +
            "2017-10-10 13:05:56.371 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:56.371 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Model --- \n" +
            "2017-10-10 13:05:56.519 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Model\\target\\WitParking.Demo-SpringBoot-Model-sources.jar \n" +
            "2017-10-10 13:05:56.610 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:56.611 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ WitParking.Demo-SpringBoot-Model --- \n" +
            "2017-10-10 13:05:56.974 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Using 'UTF-8' encoding to copy filtered resources. \n" +
            "2017-10-10 13:05:56.978 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Copying 0 resource \n" +
            "2017-10-10 13:05:56.980 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:56.981 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:compile (default-compile) @ WitParking.Demo-SpringBoot-Model --- \n" +
            "2017-10-10 13:05:57.191 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Compiling 16 source files to E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Model\\target\\classes \n" +
            "2017-10-10 13:05:59.052 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.053 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ WitParking.Demo-SpringBoot-Model --- \n" +
            "2017-10-10 13:05:59.057 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not copying test resources \n" +
            "2017-10-10 13:05:59.057 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.058 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:testCompile (default-testCompile) @ WitParking.Demo-SpringBoot-Model --- \n" +
            "2017-10-10 13:05:59.062 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not compiling test sources \n" +
            "2017-10-10 13:05:59.063 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.063 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ WitParking.Demo-SpringBoot-Model --- \n" +
            "2017-10-10 13:05:59.250 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Tests are skipped. \n" +
            "2017-10-10 13:05:59.251 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.251 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ WitParking.Demo-SpringBoot-Model --- \n" +
            "2017-10-10 13:05:59.570 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Model\\target\\WitParking.Demo-SpringBoot-Model.jar \n" +
            "2017-10-10 13:05:59.634 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]                                                                          \n" +
            "2017-10-10 13:05:59.634 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:05:59.634 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building WitParking.Demo-SpringBoot-Interfaces 1.0-SNAPSHOT \n" +
            "2017-10-10 13:05:59.634 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:05:59.792 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.793 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ WitParking.Demo-SpringBoot-Interfaces --- \n" +
            "2017-10-10 13:05:59.794 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Deleting E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Interfaces\\target \n" +
            "2017-10-10 13:05:59.866 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.866 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] >>> maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Interfaces >>> \n" +
            "2017-10-10 13:05:59.867 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.867 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] <<< maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Interfaces <<< \n" +
            "2017-10-10 13:05:59.867 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.867 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Interfaces --- \n" +
            "2017-10-10 13:05:59.931 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Interfaces\\target\\WitParking.Demo-SpringBoot-Interfaces-sources.jar \n" +
            "2017-10-10 13:05:59.949 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.949 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ WitParking.Demo-SpringBoot-Interfaces --- \n" +
            "2017-10-10 13:05:59.951 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Using 'UTF-8' encoding to copy filtered resources. \n" +
            "2017-10-10 13:05:59.951 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] skip non existing resourceDirectory E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Interfaces\\src\\main\\resources \n" +
            "2017-10-10 13:05:59.951 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:05:59.951 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:compile (default-compile) @ WitParking.Demo-SpringBoot-Interfaces --- \n" +
            "2017-10-10 13:05:59.967 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Compiling 10 source files to E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Interfaces\\target\\classes \n" +
            "2017-10-10 13:06:00.675 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:00.675 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ WitParking.Demo-SpringBoot-Interfaces --- \n" +
            "2017-10-10 13:06:00.676 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not copying test resources \n" +
            "2017-10-10 13:06:00.676 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:00.677 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:testCompile (default-testCompile) @ WitParking.Demo-SpringBoot-Interfaces --- \n" +
            "2017-10-10 13:06:00.679 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not compiling test sources \n" +
            "2017-10-10 13:06:00.679 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:00.679 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ WitParking.Demo-SpringBoot-Interfaces --- \n" +
            "2017-10-10 13:06:00.682 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Tests are skipped. \n" +
            "2017-10-10 13:06:00.683 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:00.683 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ WitParking.Demo-SpringBoot-Interfaces --- \n" +
            "2017-10-10 13:06:00.704 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Interfaces\\target\\WitParking.Demo-SpringBoot-Interfaces.jar \n" +
            "2017-10-10 13:06:00.740 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]                                                                          \n" +
            "2017-10-10 13:06:00.740 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:06:00.740 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building WitParking.Demo-SpringBoot-Repository 1.0-SNAPSHOT \n" +
            "2017-10-10 13:06:00.740 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:06:00.872 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:00.872 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ WitParking.Demo-SpringBoot-Repository --- \n" +
            "2017-10-10 13:06:00.873 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Deleting E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Repository\\target \n" +
            "2017-10-10 13:06:01.035 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:01.035 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] >>> maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Repository >>> \n" +
            "2017-10-10 13:06:01.038 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:01.038 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] <<< maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Repository <<< \n" +
            "2017-10-10 13:06:01.038 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:01.039 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Repository --- \n" +
            "2017-10-10 13:06:01.085 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Repository\\target\\WitParking.Demo-SpringBoot-Repository-sources.jar \n" +
            "2017-10-10 13:06:01.125 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:01.126 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ WitParking.Demo-SpringBoot-Repository --- \n" +
            "2017-10-10 13:06:01.127 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Using 'UTF-8' encoding to copy filtered resources. \n" +
            "2017-10-10 13:06:01.128 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] skip non existing resourceDirectory E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Repository\\src\\main\\resources \n" +
            "2017-10-10 13:06:01.128 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:01.128 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:compile (default-compile) @ WitParking.Demo-SpringBoot-Repository --- \n" +
            "2017-10-10 13:06:01.134 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Compiling 5 source files to E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Repository\\target\\classes \n" +
            "2017-10-10 13:06:01.977 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:01.977 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ WitParking.Demo-SpringBoot-Repository --- \n" +
            "2017-10-10 13:06:01.979 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not copying test resources \n" +
            "2017-10-10 13:06:01.979 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:01.980 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:testCompile (default-testCompile) @ WitParking.Demo-SpringBoot-Repository --- \n" +
            "2017-10-10 13:06:01.982 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not compiling test sources \n" +
            "2017-10-10 13:06:01.982 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:01.982 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ WitParking.Demo-SpringBoot-Repository --- \n" +
            "2017-10-10 13:06:01.986 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Tests are skipped. \n" +
            "2017-10-10 13:06:01.986 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:01.986 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ WitParking.Demo-SpringBoot-Repository --- \n" +
            "2017-10-10 13:06:02.003 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Repository\\target\\WitParking.Demo-SpringBoot-Repository.jar \n" +
            "2017-10-10 13:06:02.031 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]                                                                          \n" +
            "2017-10-10 13:06:02.031 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:06:02.032 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building WitParking.Demo-SpringBoot-Service 1.0-SNAPSHOT \n" +
            "2017-10-10 13:06:02.032 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:06:02.467 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:02.467 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ WitParking.Demo-SpringBoot-Service --- \n" +
            "2017-10-10 13:06:02.469 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Deleting E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Service\\target \n" +
            "2017-10-10 13:06:02.681 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:02.681 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] >>> maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Service >>> \n" +
            "2017-10-10 13:06:02.682 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:02.683 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] <<< maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Service <<< \n" +
            "2017-10-10 13:06:02.683 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:02.683 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-SpringBoot-Service --- \n" +
            "2017-10-10 13:06:03.023 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Service\\target\\WitParking.Demo-SpringBoot-Service-sources.jar \n" +
            "2017-10-10 13:06:03.070 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:03.070 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ WitParking.Demo-SpringBoot-Service --- \n" +
            "2017-10-10 13:06:03.071 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Using 'UTF-8' encoding to copy filtered resources. \n" +
            "2017-10-10 13:06:03.071 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] skip non existing resourceDirectory E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Service\\src\\main\\resources \n" +
            "2017-10-10 13:06:03.071 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:03.072 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:compile (default-compile) @ WitParking.Demo-SpringBoot-Service --- \n" +
            "2017-10-10 13:06:03.096 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Compiling 67 source files to E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Service\\target\\classes \n" +
            "2017-10-10 13:06:06.544 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:06.544 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ WitParking.Demo-SpringBoot-Service --- \n" +
            "2017-10-10 13:06:06.545 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not copying test resources \n" +
            "2017-10-10 13:06:06.546 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:06.546 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:testCompile (default-testCompile) @ WitParking.Demo-SpringBoot-Service --- \n" +
            "2017-10-10 13:06:06.548 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not compiling test sources \n" +
            "2017-10-10 13:06:06.548 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:06.548 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ WitParking.Demo-SpringBoot-Service --- \n" +
            "2017-10-10 13:06:06.552 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Tests are skipped. \n" +
            "2017-10-10 13:06:06.552 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:06.552 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ WitParking.Demo-SpringBoot-Service --- \n" +
            "2017-10-10 13:06:06.669 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Service\\target\\WitParking.Demo-SpringBoot-Service.jar \n" +
            "2017-10-10 13:06:06.866 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]                                                                          \n" +
            "2017-10-10 13:06:06.867 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:06:06.867 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building WitParking.Demo-Web 1.0-SNAPSHOT \n" +
            "2017-10-10 13:06:06.867 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:06:07.245 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:07.245 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:07.246 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Deleting E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Web\\target \n" +
            "2017-10-10 13:06:07.332 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:07.333 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] >>> maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-Web >>> \n" +
            "2017-10-10 13:06:07.335 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:07.335 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- buildnumber-maven-plugin:1.4:create-timestamp (default) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:08.012 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:08.012 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- properties-maven-plugin:1.0.0:read-project-properties (default) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:08.056 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:08.056 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] <<< maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-Web <<< \n" +
            "2017-10-10 13:06:08.056 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:08.057 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-source-plugin:3.0.1:jar (default-cli) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:08.098 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Web\\target\\WitParking.Demo-Web_${server.port}_D${dubbo.port}_${timestamp}-sources.jar \n" +
            "2017-10-10 13:06:08.140 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:08.140 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- buildnumber-maven-plugin:1.4:create-timestamp (default) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:08.141 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:08.141 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- properties-maven-plugin:1.0.0:read-project-properties (default) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:08.142 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:08.143 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:08.144 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Using 'UTF-8' encoding to copy filtered resources. \n" +
            "2017-10-10 13:06:08.148 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Copying 13 resources \n" +
            "2017-10-10 13:06:08.204 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:08.204 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:compile (default-compile) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:08.209 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Compiling 8 source files to E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Web\\target\\classes \n" +
            "2017-10-10 13:06:09.015 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:09.016 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:09.016 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not copying test resources \n" +
            "2017-10-10 13:06:09.016 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:09.016 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-compiler-plugin:2.5.1:testCompile (default-testCompile) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:09.020 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Not compiling test sources \n" +
            "2017-10-10 13:06:09.020 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:09.020 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:09.023 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Tests are skipped. \n" +
            "2017-10-10 13:06:09.023 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:09.023 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:09.044 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Building jar: E:\\IDEAWorkspace\\WitParking.Demo-SpringBoot\\WitParking.Demo-SpringBoot-Web\\target\\WitParking.Demo-Web_31110_D30732_20171010_1306.jar \n" +
            "2017-10-10 13:06:09.088 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:09.088 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] --- spring-boot-maven-plugin:1.4.1.RELEASE:repackage (default) @ WitParking.Demo-Web --- \n" +
            "2017-10-10 13:06:11.487 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:06:11.487 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Reactor Summary: \n" +
            "2017-10-10 13:06:11.488 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO]  \n" +
            "2017-10-10 13:06:11.488 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot ........................ SUCCESS [1.159s] \n" +
            "2017-10-10 13:06:11.488 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot-Model .................. SUCCESS [5.335s] \n" +
            "2017-10-10 13:06:11.488 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot-Interfaces ............. SUCCESS [1.106s] \n" +
            "2017-10-10 13:06:11.488 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot-Repository ............. SUCCESS [1.291s] \n" +
            "2017-10-10 13:06:11.488 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-SpringBoot-Service ................ SUCCESS [4.835s] \n" +
            "2017-10-10 13:06:11.489 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] WitParking.Demo-Web ............................... SUCCESS [4.621s] \n" +
            "2017-10-10 13:06:11.489 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:06:11.489 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] BUILD SUCCESS \n" +
            "2017-10-10 13:06:11.489 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ \n" +
            "2017-10-10 13:06:11.489 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Total time: 19.162s \n" +
            "2017-10-10 13:06:11.489 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Finished at: Tue Oct 10 13:06:11 CST 2017 \n" +
            "2017-10-10 13:06:11.951 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] Final Memory: 46M/432M \n" +
            "2017-10-10 13:06:11.952 [main] INFO  com.owl.maven.MavenGetPrintResolve - [INFO] ------------------------------------------------------------------------ ";

    private static final Pattern pattern =Pattern.compile("(?<=Building jar: )(.*)(?=\n)");//匹配的模式

    public static void main(String[] args) throws Exception {
        //<2>判断构建是否成功
        boolean buildFlag = log.contains(MavenC.BUILD_SUCCESS);
        if(!buildFlag) {
            throw new Exception("maven build error!");
        }
        //<3>正则表达式解析Build日志
        Matcher matcher = pattern.matcher(log);
        if(matcher.groupCount() <= 0) {
            throw new Exception("jar not found!");
        }
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
        //3.1解析获得Jar路径
        String jarPath = matcher.group(matcher.groupCount() - 1);
        if(StringUtils.isBlank(jarPath)) {
            throw new Exception("jar not found!");
        }
        //3.2解析获得包名
        String[] jarSplit = jarPath.split("\\\\");
        String jarName = jarSplit[jarSplit.length - 1];
        //<4>填充数据
        System.out.println("jarName:" + jarName);
        System.out.println("jarPath:" + jarPath);
    }
}
                                                  