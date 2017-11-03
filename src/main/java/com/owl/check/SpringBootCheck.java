package com.owl.check;

import com.owl.core.interfaces.ISpringBootCheck;
import com.owl.core.model.Result;

import java.util.List;

/**
 * Created by wanghouping on 2017/10/1.
 * @author wang hou ping
 */
public class SpringBootCheck implements ISpringBootCheck{

    @Override
    public Result checkDubbo(List<String> serviceNames, String url) {
        return new Result();
    }

    @Override
    public Result checkRunStatus() {
        return new Result();
    }

}
