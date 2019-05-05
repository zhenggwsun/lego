package com.zhangweinan.component;

import com.zhangweinan.dao.objects.AddressDO;
import com.zhangweinan.model.order.AddressOrder;

import java.util.List;

/**
 * 购物车组件
 * Created by Eric on 2019/4/17.
 */
public interface AddressComponent {
    /**
     * 查询地址
     * @param userId
     * @return
     */
    public List<AddressDO> queryAddress(Integer userId);

    /**
     * 新增地址
     * @param order
     * @return
     */
    public Boolean add(AddressOrder order, Integer userId);
}