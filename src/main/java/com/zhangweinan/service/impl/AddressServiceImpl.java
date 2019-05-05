package com.zhangweinan.service.impl;

import com.zhangweinan.component.AddressComponent;
import com.zhangweinan.dao.objects.AddressDO;
import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import com.zhangweinan.model.order.AddressOrder;
import com.zhangweinan.model.order.CartOrder;
import com.zhangweinan.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Eric on 2019/4/17.
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressComponent addressComponent;

    @Override
    public Result add(HttpSession session, AddressOrder order) {
        Result result = new Result();
        UserDO user = (UserDO) session.getAttribute("user");
        if (user == null){
            throw new WebsiteException(WebsiteCodeEnum.USER_NEDD_LOGIN);
        }
        Boolean success = addressComponent.add(order, user.getId());
        result.setSuccess(success);
        return result;
    }

    @Override
    public Result delete(HttpSession session, CartOrder order) {
        return null;
    }

    @Override
    public Result show(HttpSession session) {
        Result result = new Result();
        UserDO user = (UserDO) session.getAttribute("user");
        if (user == null){
            throw new WebsiteException(WebsiteCodeEnum.USER_NEDD_LOGIN);
        }
        List<AddressDO> addressDOS = addressComponent.queryAddress(user.getId());
        result.fillSuccData(addressDOS);
        return result;
    }
}
