package com.zhangweinan.model.order;

/**
 * 购物车order
 * Created by Eric on 2019/5/2.
 */
public class CartOrder {

    private Integer productId;

    private Integer size;

    private Integer number;

    public CartOrder() {
    }

    public CartOrder(Integer productId, Integer size, Integer number) {
        this.productId = productId;
        this.size = size;
        this.number = number;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
}
