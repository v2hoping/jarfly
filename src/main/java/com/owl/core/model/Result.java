package com.owl.core.model;

/**
 * Created by wanghouping on 2017/9/28.
 * 验证结果
 * @author wang hou ping
 */
public class Result {

    /**
     * 验证结果.
     */
    private boolean flag;

    /**
     * 错误原因.
     */
    private String errorMsg;

    /**
     * Gets errorMsg.
     *
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Sets errorMsg.
     *
     * @param errorMsg the errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
