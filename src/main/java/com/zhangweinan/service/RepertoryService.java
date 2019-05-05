package com.zhangweinan.service;

import com.zhangweinan.model.common.Result;

/**
 * Created by Eric on 2019/4/17.
 */
public interface RepertoryService {
    /**
     * 库存列表查询(分页)
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Result queryRepertroyList(Integer productId, int pageNum, int pageSize);

    /**
     * 删除
     * @param id
     * @return
     */
    public Result delete(Integer id);

    /**
     * 新增
     * @param productId
     * @param size
     * @param forSale
     * @return
     */
    public Result add(Integer productId, Integer size, Integer forSale);

    /**
     * 查询
     * @param id
     * @return
     */
    public Result queryInfo(Integer id);

    /**
     * 更新
     * @param id
     * @param productId
     * @param size
     * @param forSale
     * @return
     */
    public Result update(Integer id, Integer productId, Integer size, Integer forSale);
}
