package com.zhangweinan.model.model;

import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.dao.objects.RepertoryDO;

/**
 * 购物车模型
 * Created by Eric on 2019/5/2.
 */
public class CartItemModel {

    private ProductDO product;

    private RepertoryDO repertory;

    private Integer num;

    public CartItemModel() {
    }

    public CartItemModel(ProductDO product, RepertoryDO repertory, Integer num) {
        this.product = product;
        this.repertory = repertory;
        this.num = num;
    }

    public ProductDO getProduct() {
        return product;
    }

    public void setProduct(ProductDO product) {
        this.product = product;
    }

    public RepertoryDO getRepertory() {
        return repertory;
    }

    public void setRepertory(RepertoryDO repertory) {
        this.repertory = repertory;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
