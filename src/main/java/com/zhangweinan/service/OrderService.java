package com.zhangweinan.service;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.AddressOrder;
import com.zhangweinan.model.order.CartOrder;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Eric on 2019/4/17.
 */
public interface OrderService {
    /**
     * 生成订单
     * @return
     */
    public Result create(HttpSession session, Integer addressId);

    /**
     * 查询订单列表
     * @param start
     * @param end
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Result queryOrderList(String start, String end, int pageNum, int pageSize);

    /**
     * 查询订单列表（所有）
     * @return
     */
    public Result queryOrderList();


}
