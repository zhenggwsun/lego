package com.zhangweinan.model.exception;

import com.zhangweinan.model.enums.WebsiteCodeEnum;

/**
 * 自定义异常
 * Created by Eric on 2019/4/13.
 */
public class WebsiteException extends RuntimeException{

    private String resultCode;

    private String resultMsg;

    public WebsiteException(String resultCode, String resultMsg) {
        super(resultCode);
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public WebsiteException(WebsiteCodeEnum codeEnum) {
        super(codeEnum.getCode());
        this.resultCode = codeEnum.getCode();
        this.resultMsg = codeEnum.getDesc();
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
