package com.zhangweinan.web.controller.sysbench;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.UserOrder;
import com.zhangweinan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Eric on 2019/4/17.
 */
@Controller
@RequestMapping("sysbench/user")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "loginPage", method = RequestMethod.GET)
    public String queryProduct(HttpServletRequest request, HttpServletResponse response){
        return "/sysbench/login";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password){
        HttpSession session = request.getSession();
        Result result = userService.adminLogin(session, username, password);
        return result;
    }

    @RequestMapping(value = "destroy", method = RequestMethod.GET)
    public String destroy(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        return "redirect:/sysbench/loginPage";
    }
}
