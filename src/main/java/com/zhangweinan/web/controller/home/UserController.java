package com.zhangweinan.web.controller.home;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.UserOrder;
import com.zhangweinan.service.ProductService;
import com.zhangweinan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Eric on 2019/4/17.
 */
@Controller
@RequestMapping("home/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "registerPage", method = RequestMethod.GET)
    public String queryNewProductList(HttpServletRequest request, HttpServletResponse response){
        return "/home/register";
    }

    @RequestMapping(value = "loginPage", method = RequestMethod.GET)
    public String queryProduct(HttpServletRequest request, HttpServletResponse response){
        return "/home/login";
    }


    @RequestMapping(value = "verificationCode", method = RequestMethod.POST)
    @ResponseBody
    public Result verificationCode(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value = "phoneNumber")String phoneNumber){
        HttpSession session = request.getSession();
        Result result = userService.verificationCode(session, phoneNumber);
        return result;
    }


    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "realName")String realName,
                           @RequestParam(value = "sex")String sex,
                           @RequestParam(value = "age")Integer age,
                           @RequestParam(value = "telephone")String telephone,
                           @RequestParam(value = "address")String address,
                           @RequestParam(value = "displayName")String displayName,
                           @RequestParam(value = "username")String username,
                           @RequestParam(value = "password")String password){
        UserOrder userOrder = new UserOrder();
        userOrder.setRealName(realName);
        userOrder.setSex(sex);
        userOrder.setAge(age);
        userOrder.setTel(telephone);
        userOrder.setAddress(address);
        userOrder.setDisplayName(displayName);
        userOrder.setUsername(username);
        userOrder.setPassword(password);
        Result result = userService.register(userOrder);
        return result;
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password){
        HttpSession session = request.getSession();
        Result result = userService.login(session, username, password);
        return result;
    }

    @RequestMapping(value = "destroy", method = RequestMethod.GET)
    public String destroy(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/home/index";
    }
}
