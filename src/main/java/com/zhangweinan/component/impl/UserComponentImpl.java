package com.zhangweinan.component.impl;

import com.zhangweinan.component.UserComponent;
import com.zhangweinan.dao.UserDOMapper;
import com.zhangweinan.dao.UserInfoDOMapper;
import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.dao.objects.UserInfoDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.convert.UserConvert;
import com.zhangweinan.model.enums.UserTypeEnum;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import com.zhangweinan.model.model.UserAgeChartsModel;
import com.zhangweinan.model.model.UserExportModel;
import com.zhangweinan.model.model.UserModel;
import com.zhangweinan.model.order.UserOrder;
import com.zhangweinan.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.zhangweinan.model.convert.UserConvert.convert2UserDO;
import static com.zhangweinan.model.convert.UserConvert.convert2UserInfoDO;

/**
 * Created by Eric on 2019/5/1.
 */
@Service("userComponent")
public class UserComponentImpl implements UserComponent{

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserInfoDOMapper userInfoDOMapper;

    @Override
    public UserDO login(String username, String password) {

        UserDO userDO = userDOMapper.selectByUsername(username, UserTypeEnum.USER.getType());
        if (userDO == null){
            throw new WebsiteException(WebsiteCodeEnum.USER_NOT_EXIST);
        }
        if (!userDO.getPassword().equals(MD5Util.md5Hex(password))){
            throw new WebsiteException(WebsiteCodeEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        return userDO;
    }

    @Override
    public UserDO adminLogin(String username, String password) {
        UserDO userDO = userDOMapper.selectByUsername(username, UserTypeEnum.ADMIN.getType());
        if (userDO == null){
            throw new WebsiteException(WebsiteCodeEnum.USER_NOT_EXIST);
        }
        if (!userDO.getPassword().equals(password)){
            throw new WebsiteException(WebsiteCodeEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        return userDO;
    }

    @Override
    public Boolean register(UserOrder order) {
        //lego_user 插入
        UserDO userDO = convert2UserDO(order);
        int i = userDOMapper.insert(userDO);
        if (i < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        //lego_user_info插入
        UserInfoDO infoDO = convert2UserInfoDO(order);
        infoDO.setUserId(userDO.getId());
        int k = userInfoDOMapper.insert(infoDO);
        if (k < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        return true;
    }

    @Override
    public PaginationModel<UserModel> queryUserList(String username, int pageNum, int pageSize) {
        PaginationModel<UserModel> paginationModel = new PaginationModel<UserModel>();
        int from = (pageNum -1)*pageSize;
        List<UserModel> list = userDOMapper.selectByPage(username, from, pageSize);
        int total = userDOMapper.selectCount(username);

        paginationModel.setList(list);
        paginationModel.setTotal(total);
        paginationModel.fillPageModel(pageNum, pageSize, total);
        return paginationModel;
    }

    @Override
    public List<UserExportModel> queryUserList() {

        List<UserExportModel> list = userDOMapper.selectList();
        return list;
    }

    @Override
    public UserAgeChartsModel queryAgeCountCharts() {
        UserAgeChartsModel model = new UserAgeChartsModel();
        int ltTwenty = userInfoDOMapper.selectCountAgeltTwenty();
        int ttof = userInfoDOMapper.selectCountAgeTwentyToForty();
        int ftos= userInfoDOMapper.selectCountAgeFortyToSixty();
        int gtSixty = userInfoDOMapper.selectCountAgegtSixty();

        model.setLtTwenty(ltTwenty);
        model.setTwentyToForty(ttof);
        model.setFortyToSixty(ftos);
        model.setGtSixty(gtSixty);
        return model;
    }
}
