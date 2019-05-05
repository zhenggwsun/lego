package com.zhangweinan.model.convert;

import com.sun.org.apache.regexp.internal.RE;
import com.zhangweinan.dao.objects.AddressDO;
import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.dao.objects.UserInfoDO;
import com.zhangweinan.model.enums.UserTypeEnum;
import com.zhangweinan.model.order.AddressOrder;
import com.zhangweinan.model.order.UserOrder;
import com.zhangweinan.util.MD5Util;

import java.util.Date;

/**
 * 地址相关转换
 * Created by Eric on 2019/5/1.
 */
public class AddressConvert {

    public static AddressDO convert2AddressDO(AddressOrder order){
        if (order == null){
            return null;
        }
        AddressDO addressDO = new AddressDO();
        addressDO.setFullName(order.getFullName());
        addressDO.setTel(order.getTel());
        addressDO.setFullAddress(order.getFullAddress());
        addressDO.setAddressDetail(order.getAddressDetail());
        addressDO.setGmtCreate(new Date());
        addressDO.setGmtModify(new Date());
        return addressDO;
    }

}
