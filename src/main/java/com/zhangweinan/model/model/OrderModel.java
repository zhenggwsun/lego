package com.zhangweinan.model.model;

/**
 * 订单模型
 * Created by Eric on 2019/5/2.
 */
public class OrderModel {

    private Integer productId;

    private Integer addressId;

    private Integer userId;

    private Integer size;

    private Integer num;

    private Double cost;

    public OrderModel() {
    }

    public OrderModel(Integer productId, Integer addressId, Integer userId, Integer size, Integer num, Double cost) {
        this.productId = productId;
        this.addressId = addressId;
        this.userId = userId;
        this.size = size;
        this.num = num;
        this.cost = cost;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
