package com.owl.core.interfaces;

import com.owl.core.model.Config;
import com.owl.core.model.InputConfig;

/**
 * Created by wanghouping on 2017/10/7.
 * @author wang hou ping
 */
public interface IInputConfigProcess {

    /**
     * 填充输入配置数据.
     */
    void fillInputConfig(Config config, InputConfig inputConfig);
}
