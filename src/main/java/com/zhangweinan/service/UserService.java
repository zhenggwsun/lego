package com.zhangweinan.service;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.UserOrder;

import javax.servlet.http.HttpSession;

/**
 * Created by Eric on 2019/4/22.
 */
public interface UserService {

    /**
     * 验证码
     * @return
     */
    public Result verificationCode(HttpSession session, String phoneNumber);

    /**
     * 注册
     * @return
     */
    public Result register(UserOrder userOrder);

    /**
     * 登录(普通用户)
     * @return
     */
    public Result login(HttpSession session, String username, String password);

    /**
     * 管理员登录
     * @param session
     * @param username
     * @param password
     * @return
     */
    public Result adminLogin(HttpSession session, String username, String password);

    /**
     * 查询用户列表
     * @param username
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Result queryUserList(String username, int pageNum, int pageSize);

    /**
     * 查询全部用户
     * @return
     */
    public Result queryUserList();

}
