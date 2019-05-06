package com.zhangweinan.service.impl;

import com.zhangweinan.component.UserComponent;
import com.zhangweinan.dao.objects.RepertoryDO;
import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.model.UserAgeChartsModel;
import com.zhangweinan.model.model.UserExportModel;
import com.zhangweinan.model.model.UserModel;
import com.zhangweinan.model.order.UserOrder;
import com.zhangweinan.service.UserService;
import com.zhangweinan.util.CodesUtil;
import com.zhangweinan.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Eric on 2019/4/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserComponent userComponent;

    @Override
    public Result verificationCode(HttpSession session, String phoneNumber) {
        Result result = new Result();
        String code = CodesUtil.getCodex(4);
        boolean success = MessageUtil.sendMessage(code, phoneNumber);
        session.setAttribute("verificationCode", code);
        result.setSuccess(success);
//        result.setSuccess(true);
        return result;
    }

    @Override
    public Result register(UserOrder userOrder) {
        Result result = new Result();
        Boolean success = userComponent.register(userOrder);
        result.setSuccess(success);
        return result;
    }

    @Override
    public Result login(HttpSession session, String username, String password) {
        Result result = new Result();
        UserDO userDO = userComponent.login(username, password);
        session.setAttribute("user", userDO);
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result adminLogin(HttpSession session, String username, String password) {
        Result result = new Result();
        UserDO userDO = userComponent.adminLogin(username, password);
        session.setAttribute("admin", userDO);
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result queryUserList(String username, int pageNum, int pageSize) {
        Result result = new Result();
        PaginationModel<UserModel> paginationModel = userComponent.queryUserList(username, pageNum, pageSize);
        result.fillSuccData(paginationModel);
        return result;
    }

    @Override
    public Result queryUserList() {
        Result result = new Result();
        List<UserExportModel> userExportModels = userComponent.queryUserList();
        result.fillSuccData(userExportModels);
        return result;
    }

    @Override
    public Result queryAgeCountCharts() {
        Result result = new Result();
        UserAgeChartsModel model = userComponent.queryAgeCountCharts();
        result.fillSuccData(model);
        return result;
    }
}
