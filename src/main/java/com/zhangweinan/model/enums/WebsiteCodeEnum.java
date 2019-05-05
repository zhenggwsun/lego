package com.zhangweinan.model.enums;

/**
 * Created by Eric on 2019/4/13.
 */
public enum WebsiteCodeEnum {

    SYSTEM_ERROR("SYSTEM_ERROR", "系统异常"),
    USER_NOT_EXIST("USER_NOT_EXIST", "用户不存在"),
    USERNAME_OR_PASSWORD_ERROR("USERNAME_OR_PASSWORD_ERROR", "用户名或密码有误"),
    DATABASE_OPERATE_ERROR("DATABASE_OPERATE_ERROR", "数据库操作异常"),
    USER_NEDD_LOGIN("USER_NEDD_LOGIN", "用户未登录"),
    PRODUCT_NOT_EXIST("PRODUCT_NOT_EXIST", "产品不存在"),
    ;

    private String code;

    private String desc;

    WebsiteCodeEnum() {
    }

    WebsiteCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
