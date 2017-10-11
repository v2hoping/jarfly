package com.owl.config;

import com.owl.core.interfaces.IConfigInitProcess;
import com.owl.core.model.Config;

/**
 * Created by wanghouping on 2017/10/1.
 * @author wang hou ping
 */
public class ConfigInitDefaultProcess implements IConfigInitProcess{

    @Override
    public Config init() {
        return new Config();
    }
}
