package com.zhangweinan.component.impl;

import com.zhangweinan.component.AddressComponent;
import com.zhangweinan.dao.AddressDOMapper;
import com.zhangweinan.dao.objects.AddressDO;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import com.zhangweinan.model.order.AddressOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.zhangweinan.model.convert.AddressConvert.convert2AddressDO;

/**
 * Created by Eric on 2019/5/1.
 */
@Service("addressComponent")
public class AddressComponentImpl implements AddressComponent{

    @Autowired
    private AddressDOMapper addressDOMapper;

    @Override
    public List<AddressDO> queryAddress(Integer userId) {
        List<AddressDO> addressDOS = addressDOMapper.selectByUserId(userId);
        return addressDOS;
    }

    @Override
    public Boolean add(AddressOrder order, Integer userId) {
        AddressDO addressDO = convert2AddressDO(order);
        addressDO.setUserId(userId);
        int i = addressDOMapper.insert(addressDO);
        if (i < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        return true;
    }
}
