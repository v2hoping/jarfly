package com.owl.core.interfaces;

import com.owl.core.model.Config;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by wanghouping on 2017/9/28.
 * Maven日志解析.
 * @author wang hou ping
 */
public interface IMavenLogResolve {

    void resolve(Config config, BufferedReader normalBufferedReader, BufferedReader errorBufferedReader) throws Exception;
}
