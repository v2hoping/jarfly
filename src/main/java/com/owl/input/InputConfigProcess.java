package com.owl.input;

import com.owl.core.interfaces.IInputConfigProcess;
import com.owl.core.model.Config;
import com.owl.core.model.InputConfig;

/**
 * Created by wanghouping on 2017/10/7.
 * 输入外部配置.
 * @author wang hou ping
 */
public class InputConfigProcess implements IInputConfigProcess {

    @Override
    public void fillInputConfig(Config config, InputConfig inputConfig) {
        config.setUserName(inputConfig.getUserName());
        config.setPassword(inputConfig.getPassword());
        config.setRsaKey(inputConfig.getRsaKey());
        config.setIp(inputConfig.getIp());
        config.setPort(inputConfig.getPort());
        config.setLiunxPath(inputConfig.getLiunxPath());
        config.setPath(inputConfig.getPath());
    }
}
