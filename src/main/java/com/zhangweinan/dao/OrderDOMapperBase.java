package com.zhangweinan.dao;

import com.zhangweinan.dao.objects.OrderDO;
import com.zhangweinan.model.model.OrderExportModel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderDOMapperBase {
    /**
     * 分页查询订单
     * @param start
     * @param end
     * @param from
     * @param pageSize
     * @return
     */
    public List<OrderDO> selectByPage(@Param("start") Date start, @Param("end")Date end, @Param("from")int from, @Param("pageSize")int pageSize);

    /**
     * 数量统计
     * @param start
     * @param end
     * @return
     */
    public Integer selectCount(@Param("start")Date start, @Param("end")Date end);
}