package com.zhangweinan.model.model;

/**
 * 产品导出模型
 * Created by Eric on 2019/5/4.
 */
public class ProductExportModel {

    private Integer id;

    private String productName;

    private Double price;

    private String productDesc;

    private String category;

    private String createTime;

    public ProductExportModel() {
    }

    public ProductExportModel(Integer id, String productName, Double price, String productDesc, String category, String createTime) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.productDesc = productDesc;
        this.category = category;
        this.createTime = createTime;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
