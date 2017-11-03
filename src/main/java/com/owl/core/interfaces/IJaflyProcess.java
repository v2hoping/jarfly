package com.owl.core.interfaces;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.owl.core.model.InputConfig;

import java.io.IOException;

/**
 * Created by wanghouping on 2017/9/25.
 * 核心处理
 * @author wang hou ping
 */
public interface IJaflyProcess {

    /**
     * 处理开始.
     */
    void run() throws Exception;
}
