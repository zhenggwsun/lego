package com.zhangweinan.model.model;

import java.util.List;

/**
 * Created by Eric on 2019/5/3.
 */
public class CartModel {

    private List<CartItemModel> list;
    //总价
    private Double total;

    public CartModel() {
    }

    public CartModel(List<CartItemModel> list, Double total) {
        this.list = list;
        this.total = total;
    }

    public List<CartItemModel> getList() {
        return list;
    }

    public void setList(List<CartItemModel> list) {
        this.list = list;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
