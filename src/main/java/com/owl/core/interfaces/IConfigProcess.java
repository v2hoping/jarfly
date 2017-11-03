package com.owl.core.interfaces;

import com.owl.core.model.Config;
import com.owl.core.model.Result;
import org.dom4j.DocumentException;

import java.io.IOException;

/**
 * Created by wanghouping on 2017/10/1.
 * 解析获取项目配置文件.
 * @author wang hou ping
 */
public interface IConfigProcess {

    void fillConfig(Config config) throws IOException, DocumentException;

    /**
     * 检查配置状态.
     * @return Result
     */
    Result checkConfig();
}
