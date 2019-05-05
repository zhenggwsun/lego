package com.zhangweinan.model.model;

import com.zhangweinan.dao.objects.AddressDO;
import com.zhangweinan.dao.objects.OrderDO;
import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.dao.objects.UserDO;

/**
 * 订单模型
 * Created by Eric on 2019/5/3.
 */
public class OrderInfoModel {

    private OrderDO order;

    private UserDO user;

    private AddressDO address;

    private ProductDO product;

    public OrderInfoModel() {
    }

    public OrderInfoModel(OrderDO order, UserDO user, AddressDO address, ProductDO product) {
        this.order = order;
        this.user = user;
        this.address = address;
        this.product = product;
    }

    public OrderDO getOrder() {
        return order;
    }

    public void setOrder(OrderDO order) {
        this.order = order;
    }

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }

    public AddressDO getAddress() {
        return address;
    }

    public void setAddress(AddressDO address) {
        this.address = address;
    }

    public ProductDO getProduct() {
        return product;
    }

    public void setProduct(ProductDO product) {
        this.product = product;
    }
}
