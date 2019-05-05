package com.zhangweinan.model.enums;

/**
 *  产品类型
 * Created by Eric on 2019/4/18.
 */
public enum UserTypeEnum {
    ADMIN("ADMIN","管理员"),
    USER("USER","普通用户"),
    ;

    private String type;

    private String desc;

    UserTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static UserTypeEnum getByType(String type){
        for (UserTypeEnum typeEnum: values()) {
            if (typeEnum.getType().equals(type)){
                return typeEnum;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
