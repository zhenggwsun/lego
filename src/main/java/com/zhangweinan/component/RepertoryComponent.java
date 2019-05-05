package com.zhangweinan.component;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.dao.objects.RepertoryDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.enums.ProductTypeEnum;
import com.zhangweinan.model.model.ProductModel;

import java.util.List;

/**
 * 产品组件
 * Created by Eric on 2019/4/17.
 */
public interface RepertoryComponent {
    /**
     *
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PaginationModel<RepertoryDO> queryRepertoryList(Integer productId, int pageNum, int pageSize);

    /**
     * 删除库存记录
     * @param id
     * @return
     */
    public Boolean delete(Integer id);

    /**
     * 新增
     * @param productId
     * @param size
     * @param forSale
     * @return
     */
    public Boolean add(Integer productId, Integer size, Integer forSale);

    /**
     * 查询
     * @param id
     * @return
     */
    public RepertoryDO queryInfo(Integer id);

    /**
     * 更新
     * @param repertoryDO
     * @return
     */
    public Boolean update(RepertoryDO repertoryDO);
}
