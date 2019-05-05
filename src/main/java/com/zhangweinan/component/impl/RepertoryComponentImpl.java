package com.zhangweinan.component.impl;

import com.zhangweinan.component.ProductComponent;
import com.zhangweinan.component.RepertoryComponent;
import com.zhangweinan.dao.ProductDOMapper;
import com.zhangweinan.dao.RepertoryDOMapper;
import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.dao.objects.RepertoryDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.enums.ProductTypeEnum;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import com.zhangweinan.model.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Eric on 2019/4/17.
 */
@Service("repertoryComponent")
public class RepertoryComponentImpl implements RepertoryComponent {

    @Autowired
    private RepertoryDOMapper repertoryDOMapper;

    @Override
    public PaginationModel<RepertoryDO> queryRepertoryList(Integer productId, int pageNum, int pageSize) {
        PaginationModel<RepertoryDO> paginationModel = new PaginationModel<RepertoryDO>();
        int from = (pageNum -1)*pageSize;
        List<RepertoryDO> list = repertoryDOMapper.selectByPage(productId, from, pageSize);
        int total = repertoryDOMapper.selectCount(productId);

        paginationModel.setList(list);
        paginationModel.setTotal(total);
        paginationModel.fillPageModel(pageNum, pageSize, total);
        return paginationModel;
    }

    @Override
    public Boolean delete(Integer id) {
        int i = repertoryDOMapper.deleteByPrimaryKey(id);
        if (i < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean add(Integer productId, Integer size, Integer forSale) {
        RepertoryDO repertoryDO = new RepertoryDO();
        repertoryDO.setProductId(productId);
        repertoryDO.setSize(size);
        repertoryDO.setForSaleCount(forSale);
        repertoryDO.setGmtCreate(new Date());
        repertoryDO.setGmtModify(new Date());
        repertoryDO.setSoldCount(0);
        int i = repertoryDOMapper.insert(repertoryDO);
        if (i < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        return true;
    }

    @Override
    public RepertoryDO queryInfo(Integer id) {
        RepertoryDO repertoryDO = repertoryDOMapper.selectByPrimaryKey(id);
        return repertoryDO;
    }

    @Override
    public Boolean update(RepertoryDO repertoryDO) {
        RepertoryDO repertory = repertoryDOMapper.selectByPrimaryKey(repertoryDO.getId());
        if (repertory == null){
            throw new WebsiteException(WebsiteCodeEnum.SYSTEM_ERROR);
        }
        repertoryDO.setGmtCreate(repertory.getGmtCreate());
        repertoryDO.setSoldCount(repertory.getSoldCount());
        int i = repertoryDOMapper.updateByPrimaryKey(repertoryDO);
        if (i < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        return true;
    }
}
