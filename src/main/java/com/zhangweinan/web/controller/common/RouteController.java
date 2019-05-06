package com.zhangweinan.web.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 路由
 * Created by Eric on 2019/5/2.
 */
@Controller
public class RouteController {

    @RequestMapping(value = "home/index", method = RequestMethod.GET)
    public String homeIndex(HttpServletRequest request, HttpServletResponse response){
        return "/home/index";
    }

    @RequestMapping(value = "sysbench/index", method = RequestMethod.GET)
    public String sysbenchIndex(HttpServletRequest request, HttpServletResponse response){
        return "/sysbench/index";
    }

    @RequestMapping(value = "sysbench/productAdd", method = RequestMethod.GET)
    public String productAdd(HttpServletRequest request, HttpServletResponse response){
        return "/sysbench/product-add";
    }

    @RequestMapping(value = "sysbench/repertoryAdd", method = RequestMethod.GET)
    public String repertoryAdd(HttpServletRequest request, HttpServletResponse response){
        return "/sysbench/repertory-add";
    }

    @RequestMapping(value = "sysbench/echarts1", method = RequestMethod.GET)
    public String echarts1(HttpServletRequest request, HttpServletResponse response){
        return "/sysbench/echarts1";
    }
}
