package com.zhangweinan.component;

import com.zhangweinan.model.model.CartItemModel;
import com.zhangweinan.model.order.CartOrder;

import java.util.List;

/**
 * 购物车组件
 * Created by Eric on 2019/4/17.
 */
public interface CartComponent {
    /**
     * 查询购物车
     * @param list
     * @return
     */
    public List<CartItemModel> queryCart(List<CartOrder> list);

    /**
     * 查询购物车单列
     * @param order
     * @return
     */
    public CartItemModel queryCart(CartOrder order);
}