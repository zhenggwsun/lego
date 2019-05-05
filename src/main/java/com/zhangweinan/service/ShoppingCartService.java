package com.zhangweinan.service;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.CartOrder;

import javax.servlet.http.HttpSession;

/**
 * Created by Eric on 2019/4/17.
 */
public interface ShoppingCartService {
    /**
     * 新增购物车
     * @param session
     * @param order
     * @return
     */
    public Result add(HttpSession session, CartOrder order);

    /**
     * 更新购物车
     * @param session
     * @param order
     * @return
     */
    public Result update(HttpSession session, CartOrder order);

    /**
     * 更新购物车
     * @param session
     * @param order
     * @return
     */
    public Result delete(HttpSession session, CartOrder order);

    /**
     * 查看购物车
     * @param session
     * @return
     */
    public Result show(HttpSession session);
}
