package com.zhangweinan.web.controller.home;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.service.ProductService;
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
@RequestMapping("home/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "queryNewList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryNewList(HttpServletRequest request, HttpServletResponse response){
        Result result = productService.queryNewList();
        return result;
    }

    @RequestMapping(value = "queryHotSellList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryHotSellList(HttpServletRequest request, HttpServletResponse response){
        Result result = productService.queryHotSellList();
        return result;
    }

    @RequestMapping(value = "queryRecommendList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryRecommendList(HttpServletRequest request, HttpServletResponse response){
        Result result = productService.queryRecommendList();
        return result;
    }

    @RequestMapping(value = "queryProductList", method = RequestMethod.GET)
    public String queryProductList(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("type")String type,
                                   @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "20")int pageSize){
        Result result = productService.queryProductList(type, pageNum, pageSize);
        request.setAttribute("PaginationModel", result.getData());
        return "/home/category";
    }

    @RequestMapping(value = "queryNewProductList", method = RequestMethod.GET)
    public String queryNewProductList(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "20")int pageSize){
        Result result = productService.queryNewProductList(pageNum, pageSize);
        request.setAttribute("PaginationModel", result.getData());
        return "/home/category_new";
    }

    @RequestMapping(value = "queryProduct", method = RequestMethod.GET)
    public String queryProduct(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam(value = "id")int id){
        Result result = productService.queryProductInfo(id);
        request.setAttribute("ProductModel", result.getData());
        return "/home/product";
    }

    @RequestMapping(value = "searchProduct", method = RequestMethod.GET)
    public String searchProduct(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("key")String key,
                                   @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "20")int pageSize){
        String realPath = request.getServletContext().getRealPath("/");
        Result result = productService.searchProduct(key, pageNum, pageSize, realPath);
        request.setAttribute("PaginationModel", result.getData());
        return "/home/category_new2";
    }

}
