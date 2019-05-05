package com.zhangweinan.web.controller.common;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.order.AddressOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Eric on 2019/5/2.
 */
@Controller
@RequestMapping("common")
public class CommonController {

    @RequestMapping(value = "session/get", method = RequestMethod.GET)
    @ResponseBody
    public Result getSession(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("key")String key){
        HttpSession session = request.getSession();
        Object value = session.getAttribute(key);
        Result result = new Result();
        result.fillSuccData(value);
        return result;
    }

    @RequestMapping(value = "request/get", method = RequestMethod.GET)
    @ResponseBody
    public Result getRequest(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("key")String key){
        Object value = request.getAttribute(key);
        Result result = new Result();
        result.fillSuccData(value);
        return result;
    }
}
