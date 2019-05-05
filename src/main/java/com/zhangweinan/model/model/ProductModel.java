package com.zhangweinan.model.model;

import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.dao.objects.RepertoryDO;

import java.util.List;

/**
 * 产品模型
 * Created by Eric on 2019/4/21.
 */
public class ProductModel {
    /**
     * 产品
     */
    private ProductDO product;
    /**
     * 库存
     */
    private List<RepertoryDO> repertory;

    public ProductModel() {
    }

    public ProductModel(ProductDO product, List<RepertoryDO> repertory) {
        this.product = product;
        this.repertory = repertory;
    }

    public ProductDO getProduct() {
        return product;
    }

    public void setProduct(ProductDO product) {
        this.product = product;
    }

    public List<RepertoryDO> getRepertory() {
        return repertory;
    }

    public void setRepertory(List<RepertoryDO> repertory) {
        this.repertory = repertory;
    }
}
