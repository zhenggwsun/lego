package com.zhangweinan.web.controller.home;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.CartOrder;
import com.zhangweinan.service.OrderService;
import com.zhangweinan.service.ShoppingCartService;
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
@RequestMapping("home/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShoppingCartService shoppingCartService;
    /**
     * 生成订单
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("addressId") Integer addressId){
        HttpSession session = request.getSession();
        Result result = orderService.create(session, addressId);
        return result;
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Result result = shoppingCartService.show(session);
        request.setAttribute("cartModel", result.getData());
        return "/home/checkout";
    }

}
