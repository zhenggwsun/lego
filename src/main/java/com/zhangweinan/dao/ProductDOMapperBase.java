package com.zhangweinan.dao;

import com.zhangweinan.dao.objects.ProductDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDOMapperBase{

    /**
     * 最新10个
     * @return
     */
    List<ProductDO> selectNewTen();

    /**
     * 销量最高10个
     * @return
     */
    List<ProductDO> selectSellMostTen();

    /**
     * 1个月内销量最高10个
     * @return
     */
    List<ProductDO> selectSellMostTenInMonth();

    /**
     * 分页查询产品列表
     * @param type
     * @param from
     * @param pageSize
     * @return
     */
    List<ProductDO> selectProductList(@Param("type") String type, @Param("from")int from, @Param("pageSize")int pageSize);

    /**
     * 查询新品100
     * @param from
     * @param pageSize
     * @return
     */
    List<ProductDO> selectNewProductList(@Param("from")int from, @Param("pageSize")int pageSize);

    /**
     * 查询数量
     * @return
     */
    int selectCount();

    /**
     * 数量统计
     * @param type
     * @return
     */
    int selectProductListCount(@Param("type") String type);

    /**
     * 模糊检索
     * @param key
     * @param from
     * @param pageSize
     * @return
     */
    List<ProductDO> selectByKey(@Param("key")String key, @Param("from")int from, @Param("pageSize")int pageSize);

    Integer selectByKeyCount(@Param("key")String key);
}