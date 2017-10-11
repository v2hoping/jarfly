package com.owl.maven;

import com.owl.core.constants.MavenC;
import com.owl.core.interfaces.IMavenLogResolve;
import com.owl.core.model.Config;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wanghouping on 2017/9/28.
 * 保存数值并输出日志.
 * @author wang hou ping
 */
public class MavenGetPrintResolve implements IMavenLogResolve{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final Pattern pattern =Pattern.compile("(?<=Building jar: )(.*)(?=\n)");//匹配的模式

    @Override
    public void resolve(Config config, BufferedReader normalBufferedReader, BufferedReader errorBufferedReader) throws Exception {
        try{
            //<1>Cmd正常日志解析
            String log = "";
            String logLine = null;
            while((logLine = normalBufferedReader.readLine()) != null) {
                logger.info(logLine);
                log += logLine + "\n";
            }
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
            //3.1解析获得Jar路径
            List<String> list = new ArrayList<String>();
            while(matcher.find()) {
                list.add(matcher.group());
            }
            String jarPath = list.get(list.size() - 1);
            if(StringUtils.isBlank(jarPath)) {
                throw new Exception("jar not found!");
            }
            //3.2解析获得包名
            String[] jarSplit = jarPath.split("\\\\");
            String jarName = jarSplit[jarSplit.length - 1];
            //<4>填充数据
            config.setJarName(jarName);
            config.setJarPath(jarPath);
            config.setLiunxJarPath(config.getLiunxPath() + config.getJarName());
        }finally {
            if(normalBufferedReader != null) {
                normalBufferedReader.close();
            }
            if(errorBufferedReader != null) {
                errorBufferedReader.close();
            }
        }
    }

}
