package com.zhangweinan.model.convert;

import com.zhangweinan.dao.objects.AddressDO;
import com.zhangweinan.dao.objects.OrderDO;
import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.model.model.OrderExportModel;
import com.zhangweinan.model.model.OrderModel;
import com.zhangweinan.model.order.AddressOrder;
import org.omg.CORBA.ORB;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 地址相关转换
 * Created by Eric on 2019/5/1.
 */
public class OrderConvert {

    public static OrderModel convert2OrderModel(AddressOrder order){
        return null;
    }

    public static OrderDO convert2OrderDO(OrderModel model){
        if (model == null){
            return null;
        }
        OrderDO orderDO = new OrderDO();
        orderDO.setProductId(model.getProductId());
        orderDO.setAddressId(model.getAddressId());
        orderDO.setUserId(model.getUserId());
        orderDO.setSize(model.getSize());
        orderDO.setCost(new BigDecimal(model.getCost()));
        orderDO.setNumber(model.getNum());
        orderDO.setGmtCreate(new Date());
        orderDO.setGmtModify(new Date());
        return orderDO;
    }

    public static OrderExportModel convert2OrderExportModel(OrderDO orderDO, UserDO userDO, AddressDO addressDO, ProductDO productDO){
        if (orderDO == null){
            return null;
        }
        OrderExportModel orderExportModel = new OrderExportModel();
        orderExportModel.setId(orderDO.getId());
        orderExportModel.setSize(orderDO.getSize());
        orderExportModel.setNumber(orderDO.getNumber());
        orderExportModel.setCost(orderDO.getCost().doubleValue());
        orderExportModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderDO.getGmtCreate()));
        if (productDO != null) {
            orderExportModel.setProductName(productDO.getProductName());
        }
        if (addressDO != null) {
            orderExportModel.setAddress(addressDO.getFullAddress());
        }
        if (userDO != null) {
            orderExportModel.setDisplayName(userDO.getDisplayName());
        }
        return orderExportModel;
    }

}
