package com.zhangweinan.web.controller.home;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.CartOrder;
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
@RequestMapping("home/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("productId")Integer productId,
                      @RequestParam("size")Integer size,
                      @RequestParam(value = "number",defaultValue = "1")Integer number){
        HttpSession session = request.getSession();
        CartOrder cartOrder = new CartOrder(productId, size, number);
        Result result = shoppingCartService.add(session, cartOrder);
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String showShoppingCart(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("productId")Integer productId,
                                   @RequestParam("size")Integer size,
                                   @RequestParam(value = "number",defaultValue = "1")Integer number){
        HttpSession session = request.getSession();
        CartOrder cartOrder = new CartOrder(productId, size, number);
        Result result = shoppingCartService.update(session, cartOrder);
        return "redirect:/home/cart/showShoppingCart";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String showShoppingCart(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("productId")Integer productId,
                                   @RequestParam("size")Integer size){
        HttpSession session = request.getSession();
        CartOrder cartOrder = new CartOrder(productId, size, null);
        Result result = shoppingCartService.delete(session, cartOrder);
        return "redirect:/home/cart/showShoppingCart";
    }

    @RequestMapping(value = "showShoppingCart", method = RequestMethod.GET)
    public String showShoppingCart(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Result result = shoppingCartService.show(session);
        request.setAttribute("cartModel", result.getData());
        return "/home/cart";
    }
}
