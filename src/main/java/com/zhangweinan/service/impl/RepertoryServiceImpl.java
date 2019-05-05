package com.zhangweinan.service.impl;

import com.zhangweinan.component.AddressComponent;
import com.zhangweinan.component.RepertoryComponent;
import com.zhangweinan.dao.objects.AddressDO;
import com.zhangweinan.dao.objects.RepertoryDO;
import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import com.zhangweinan.model.order.AddressOrder;
import com.zhangweinan.model.order.CartOrder;
import com.zhangweinan.service.AddressService;
import com.zhangweinan.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Eric on 2019/4/17.
 */
@Service("repertoryService")
public class RepertoryServiceImpl implements RepertoryService {

    @Autowired
    private RepertoryComponent repertoryComponent;

    @Override
    public Result queryRepertroyList(Integer productId, int pageNum, int pageSize) {
        Result result = new Result();
        PaginationModel<RepertoryDO> paginationModel = repertoryComponent.queryRepertoryList(productId, pageNum, pageSize);
        result.fillSuccData(paginationModel);
        return result;
    }

    @Override
    public Result delete(Integer id) {
        Result result = new Result();
        Boolean success = repertoryComponent.delete(id);
        result.setSuccess(success);
        return result;
    }

    @Override
    public Result add(Integer productId, Integer size, Integer forSale) {
        Result result = new Result();
        Boolean success = repertoryComponent.add(productId, size, forSale);
        result.setSuccess(success);
        return result;
    }

    @Override
    public Result queryInfo(Integer id) {
        Result result = new Result();
        RepertoryDO repertoryDO = repertoryComponent.queryInfo(id);
        result.fillSuccData(repertoryDO);
        return result;
    }

    @Override
    public Result update(Integer id, Integer productId, Integer size, Integer forSale) {
        Result result = new Result();
        RepertoryDO repertoryDO = new RepertoryDO();
        repertoryDO.setId(id);
        repertoryDO.setProductId(productId);
        repertoryDO.setGmtModify(new Date());
        repertoryDO.setForSaleCount(forSale);
        repertoryDO.setSize(size);
        Boolean success = repertoryComponent.update(repertoryDO);
        result.setSuccess(success);
        return result;
    }
}
