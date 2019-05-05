package com.zhangweinan.model.model;

/**
 * 订单导出模型
 * Created by Eric on 2019/5/4.
 */
public class OrderExportModel {

    private Integer id;

    private String productName;

    private Integer size;

    private Integer number;

    private Double cost;

    private String address;

    private String createTime;

    private String displayName;

    public OrderExportModel() {
    }

    public OrderExportModel(Integer id, String productName, Integer size, Integer number, Double cost, String address, String createTime, String displayName) {
        this.id = id;
        this.productName = productName;
        this.size = size;
        this.number = number;
        this.cost = cost;
        this.address = address;
        this.createTime = createTime;
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
