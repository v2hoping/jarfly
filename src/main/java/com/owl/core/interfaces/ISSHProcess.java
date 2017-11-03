package com.owl.core.interfaces;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.owl.core.model.Config;
import com.owl.core.model.Result;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by wanghouping on 2017/10/1.
 *
 */
public interface ISSHProcess {

    void init(Config config);

    void login() throws JSchException, IOException, SftpException;

    void upload() throws IOException, JSchException, SftpException;

    void startUp() throws Exception;

    void shutDownOld() throws Exception;

    void rollBack();

    Result checkRunStatus();

    void closeAll() throws IOException;
}
