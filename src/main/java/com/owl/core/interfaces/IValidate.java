package com.owl.core.interfaces;

import com.owl.core.model.Result;

/**
 * Created by wanghouping on 2017/9/28.
 * 定义通用验证接口.
 * @author wang hou ping
 */
public interface IValidate {

    /**
     * 使用验证类和注解进行验证.
     * @param object 验证实体.
     * @return 验证结果
     */
    Result validate(Object object);
}
