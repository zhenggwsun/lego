package com.zhangweinan.component.impl;

import com.zhangweinan.component.AddressComponent;
import com.zhangweinan.component.OrderComponent;
import com.zhangweinan.dao.*;
import com.zhangweinan.dao.objects.*;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import com.zhangweinan.model.model.OrderExportModel;
import com.zhangweinan.model.model.OrderInfoModel;
import com.zhangweinan.model.model.OrderModel;
import com.zhangweinan.model.order.AddressOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static com.zhangweinan.model.convert.AddressConvert.convert2AddressDO;
import static com.zhangweinan.model.convert.OrderConvert.convert2OrderDO;
import static com.zhangweinan.model.convert.OrderConvert.convert2OrderExportModel;

/**
 * Created by Eric on 2019/5/1.
 */
@Service("orderComponent")
public class OrderComponentImpl implements OrderComponent{

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private AddressDOMapper addressDOMapper;

    @Autowired
    private ProductDOMapper productDOMapper;

    @Autowired
    private RepertoryDOMapper repertoryDOMapper;
    @Override
    public Boolean add(OrderModel model) {
        OrderDO orderDO = convert2OrderDO(model);
        int i = orderDOMapper.insert(orderDO);
        if (i < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        RepertoryDO repertoryDO = repertoryDOMapper.selectByProductIdAndSize(orderDO.getProductId(), orderDO.getSize());
        repertoryDO.setSoldCount(repertoryDO.getSoldCount()+orderDO.getNumber());
        repertoryDO.setForSaleCount(repertoryDO.getForSaleCount() - orderDO.getNumber());

        repertoryDOMapper.updateByPrimaryKey(repertoryDO);
        return true;
    }

    @Override
    public PaginationModel<OrderInfoModel> queryOrderList(Date start, Date end, int pageNum, int pageSize) {
        PaginationModel<OrderInfoModel> paginationModel = new PaginationModel<OrderInfoModel>();
        //订单查询
        int from = (pageNum -1)*pageSize;
        List<OrderDO> list = orderDOMapper.selectByPage(start, end, from, pageSize);
        int total = orderDOMapper.selectCount(start, end);
        List<OrderInfoModel> modelList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)){
            Iterator<OrderDO> iterator = list.iterator();
            while (iterator.hasNext()){
                OrderDO order = iterator.next();
                UserDO userDO = userDOMapper.selectByPrimaryKey(order.getUserId());
                AddressDO addressDO = addressDOMapper.selectByPrimaryKey(order.getAddressId());
                ProductDO productDO = productDOMapper.selectByPrimaryKey(order.getProductId());
                OrderInfoModel orderInfoModel = new OrderInfoModel(order, userDO, addressDO, productDO);
                modelList.add(orderInfoModel);
            }
        }
        paginationModel.setList(modelList);
        paginationModel.setTotal(total);
        paginationModel.fillPageModel(pageNum, pageSize, total);
        return paginationModel;
    }

    @Override
    public List<OrderExportModel> queryOrderList() {
        List<OrderExportModel> list = new ArrayList<>();
        List<OrderDO> orderDOS = orderDOMapper.selectAll();
        if (!CollectionUtils.isEmpty(orderDOS)){
            Iterator<OrderDO> iterator = orderDOS.iterator();
            while (iterator.hasNext()){
                OrderDO order = iterator.next();
                UserDO userDO = userDOMapper.selectByPrimaryKey(order.getUserId());
                AddressDO addressDO = addressDOMapper.selectByPrimaryKey(order.getAddressId());
                ProductDO productDO = productDOMapper.selectByPrimaryKey(order.getProductId());
                OrderExportModel orderExportModel = convert2OrderExportModel(order, userDO, addressDO, productDO);
                list.add(orderExportModel);
            }
        }
        return list;
    }
}
