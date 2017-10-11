package com.owl.utils;

import com.owl.core.interfaces.IMavenLogResolve;
import com.owl.core.model.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by wanghouping on 2017/9/28.
 * 执行Windos的CMD命令.
 * @author wang hou ping
 */
public class CmdUtils {

    private static final Logger logger = LoggerFactory.getLogger(CmdUtils.class);

    /**
     * 输出日志Cmd
     * @param config 配置
     * @param cmd CMD命令
     * @param iMavenLogResolve 解析接口
     * @throws IOException
     * @throws InterruptedException
     */
    public static void cmdPrintLog(Config config, String cmd, IMavenLogResolve iMavenLogResolve) throws Exception {
        BufferedReader bufferedReader = null;
        BufferedReader bufferedErrorReader = null;
        Process exec = null;
        try{
            //<1>生成项目目录文件对象
            File file = new File(config.getPath());
            //<2>执行Maven打包命令
            exec = Runtime.getRuntime().exec(cmd, null, file);
            //<3>正常日志流
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            //<4>异常日志流
            bufferedErrorReader = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            //<5>解析
            iMavenLogResolve.resolve(config, bufferedReader, bufferedErrorReader);
            exec.waitFor();
        }finally {
            if(bufferedReader != null) {
                bufferedReader.close();
            }
            if(exec != null) {
                exec.destroy();
            }
        }
    }
}
