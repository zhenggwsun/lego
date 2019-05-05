package com.zhangweinan.dao;

import com.zhangweinan.dao.objects.RepertoryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepertoryDOMapperBase {
    /**
     * 查询产品库存
     * @param id
     * @return
     */
    List<RepertoryDO> selectByProductId(@Param("id") int id);

    /**
     * 库存查询
     * @param id
     * @param size
     * @return
     */
    RepertoryDO selectByProductIdAndSize(@Param("id") int id, @Param("size") int size);

    /**
     * 分页查询
     * @param productId
     * @param from
     * @param pageSize
     * @return
     */
    List<RepertoryDO> selectByPage(@Param("productId") Integer productId, @Param("from")int from, @Param("pageSize")int pageSize);

    /**
     * 查询数量
     * @return
     */
    int selectCount(@Param("productId") Integer productId);
}