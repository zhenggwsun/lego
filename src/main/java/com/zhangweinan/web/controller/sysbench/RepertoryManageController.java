package com.zhangweinan.web.controller.sysbench;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.service.ProductService;
import com.zhangweinan.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Eric on 2019/4/17.
 */
@Controller
@RequestMapping("sysbench/repertory")
public class RepertoryManageController {

    @Autowired
    private RepertoryService repertoryService;

    @RequestMapping(value = "queryList", method = RequestMethod.GET)
    public String queryProductList(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value = "productId", required = false) Integer productId,
                                   @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        Result result = repertoryService.queryRepertroyList(productId, pageNum, pageSize);
        request.setAttribute("PaginationModel", result.getData());
        return "/sysbench/repertory-list";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value = "id") Integer id) {
        Result result = repertoryService.delete(id);
        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("productId") Integer productId,
                      @RequestParam("size") Integer size,
                      @RequestParam("forSale") Integer forSale){
        Result result = repertoryService.add(productId, size, forSale);
        return result;
    }

    @RequestMapping(value = "queryInfo", method = RequestMethod.GET)
    public String queryInfo(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("id") Integer id) {
        Result result = repertoryService.queryInfo(id);
        request.setAttribute("model", result.getData());
        return "/sysbench/repertory-edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam("id") Integer id,
                         @RequestParam("productId") Integer productId,
                         @RequestParam("size") Integer size,
                         @RequestParam("forSale") Integer forSale) {
        Result result = repertoryService.update(id, productId, size, forSale);
        return result;
    }
}
