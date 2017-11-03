package com.owl.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by wanghouping on 2017/9/29.
 * 数据读取.
 */
public class PropertiesUtils {

    public static Properties getProperties(String appliationProperties) throws IOException {
        InputStream resourceAsStream = null;
        try{
            resourceAsStream = PropertiesUtils.class.getResourceAsStream(appliationProperties);
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            return properties;
        }finally {
            if(resourceAsStream != null) {
                resourceAsStream.close();
            }
        }
    }
}
