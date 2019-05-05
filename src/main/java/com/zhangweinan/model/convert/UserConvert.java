package com.zhangweinan.model.convert;

import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.dao.objects.UserInfoDO;
import com.zhangweinan.model.enums.UserTypeEnum;
import com.zhangweinan.model.order.UserOrder;
import com.zhangweinan.util.MD5Util;

import java.util.Date;

/**
 * 用户相关转换
 * Created by Eric on 2019/5/1.
 */
public class UserConvert {

    /**
     * 转换为UserDO
     * @param order
     * @return
     */
    public static UserDO convert2UserDO(UserOrder order){
        if (order == null){
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setUsername(order.getUsername());
        userDO.setPassword(MD5Util.md5Hex(order.getPassword()));
        userDO.setType(UserTypeEnum.USER.getType());
        userDO.setDisplayName(order.getDisplayName());
        userDO.setGmtCreate(new Date());
        userDO.setGmtModify(new Date());
        return userDO;
    }

    /**
     * 转换为UserInfoDO
     * @param order
     * @return
     */
    public static UserInfoDO convert2UserInfoDO(UserOrder order){
        if (order == null){
            return null;
        }
        UserInfoDO infoDO = new UserInfoDO();
        infoDO.setRealName(order.getRealName());
        infoDO.setSex(order.getSex());
        infoDO.setAge(order.getAge());
        infoDO.setTel(order.getTel());
        infoDO.setAddress(order.getAddress());
        infoDO.setGmtCreate(new Date());
        infoDO.setGmtModify(new Date());
        return infoDO;
    }

}
