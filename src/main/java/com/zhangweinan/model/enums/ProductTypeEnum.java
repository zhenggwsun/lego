package com.zhangweinan.model.enums;

/**
 *  产品类型
 * Created by Eric on 2019/4/18.
 */
public enum ProductTypeEnum {
    SNEAKER_SHOES("SNEAKER_SHOES", "运动鞋"),
    CASUAL_SHOES("CASUAL_SHOES", "休闲鞋"),
    BOTTINE_SHOES("BOTTINE_SHOES", "女靴"),
    SANDAL_SHOES("SANDAL_SHOES", "凉鞋"),
    HIGH_HEELED_SHOES("HIGH_HEELED_SHOES", "高跟鞋"),
    THIN_SHOES("THIN_SHOES", "单鞋"),
    ;

    private String type;

    private String desc;

    ProductTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static ProductTypeEnum getByType(String type){
        for (ProductTypeEnum typeEnum: values()) {
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
