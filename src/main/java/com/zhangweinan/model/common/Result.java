package com.zhangweinan.model.common;

/**
 * 返回结果
 * Created by Eric on 2019/4/13.
 */
public class Result {
    //成功标志位
    private boolean success = false;

    private String errorCode;

    private String errorMsg;

    private Object data;

    public Result() {
    }

    public void fillErrorMessage(String errorCode, String errorMsg){
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public void fillSuccData(Object data){
        this.success = true;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
