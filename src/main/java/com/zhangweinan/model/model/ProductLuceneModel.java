package com.zhangweinan.model.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Eric on 2019/5/5.
 */
public class ProductLuceneModel {

    private Integer id;

    private String gmtCreate;

    private String gmtModify;

    private String productName;

    private BigDecimal price;

    private String photo;

    private String productDesc;

    private String categroy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getCategroy() {
        return categroy;
    }

    public void setCategroy(String categroy) {
        this.categroy = categroy;
    }
}
