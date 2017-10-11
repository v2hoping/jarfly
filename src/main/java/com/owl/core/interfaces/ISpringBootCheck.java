package com.owl.core.interfaces;

import com.owl.core.model.Result;

import java.util.List;

/**
 * Created by wanghouping on 2017/10/1.
 * SpringBoot 状态检查
 * @author wang hou ping
 */
public interface ISpringBootCheck {

    /**
     * Dubbo接口检查，依赖于Dubbo监控中心.
     */
    Result checkDubbo(List<String> serviceNames, String url);

    /**
     * Liunx Jar启动状态检查.
     */
    Result checkRunStatus();
}
