package com.zhangweinan.component;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhangweinan.dao.objects.AddressDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.model.OrderExportModel;
import com.zhangweinan.model.model.OrderInfoModel;
import com.zhangweinan.model.model.OrderModel;
import com.zhangweinan.model.order.AddressOrder;
import org.springframework.core.annotation.Order;

import java.util.Date;
import java.util.List;

/**
 * 订单
 * Created by Eric on 2019/4/17.
 */
public interface OrderComponent {
    /**
     * 新增订单
     *
     * @param model
     * @return
     */
    public Boolean add(OrderModel model);

    /**
     * 订单列表分页
     *
     * @param start
     * @param end
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PaginationModel<OrderInfoModel> queryOrderList(Date start, Date end, int pageNum, int pageSize);

    /**
     * 查询数据导出
     *
     * @return
     */
    public List<OrderExportModel> queryOrderList();
}