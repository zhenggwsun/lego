package com.zhangweinan.web.intercept;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 前台登录拦截
 * Created by Eric on 2019/5/4.
 */
@Component
public class HomeLoginIntercept implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null){
            response.sendRedirect("/home/user/loginPage");
            return false;
        }
        return true;
    }
}
