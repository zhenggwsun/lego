package com.zhangweinan.service;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.AddressOrder;
import com.zhangweinan.model.order.CartOrder;

import javax.servlet.http.HttpSession;

/**
 * Created by Eric on 2019/4/17.
 */
public interface AddressService {
    /**
     * 新增地址
     * @param order
     * @return
     */
    public Result add(HttpSession session, AddressOrder order);

    /**
     * 删除地址
     * @param session
     * @param order
     * @return
     */
    public Result delete(HttpSession session, CartOrder order);

    /**
     * 查看地址
     * @param session
     * @return
     */
    public Result show(HttpSession session);
}
