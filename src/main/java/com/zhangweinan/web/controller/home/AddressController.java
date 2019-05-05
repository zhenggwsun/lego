package com.zhangweinan.web.controller.home;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.AddressOrder;
import com.zhangweinan.model.order.CartOrder;
import com.zhangweinan.service.AddressService;
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
@RequestMapping("home/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("fullName")String fullName,
                      @RequestParam("tel")String tel,
                      @RequestParam("fullAddress")String fullAddress,
                      @RequestParam("addressDetail")String addressDetail){
        HttpSession session = request.getSession();
        AddressOrder order = new AddressOrder();
        order.setFullName(fullName);
        order.setTel(tel);
        order.setFullAddress(fullAddress);
        order.setAddressDetail(addressDetail);
        Result result = addressService.add(session, order);
        return result;
    }

    @RequestMapping(value = "queryList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryList(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Result result = addressService.show(session);;
        return result;
    }

    /*@RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("addressId")Integer addressId){
        Result result = shoppingCartService.add(session, cartOrder);
        return result;
    }*/
}
