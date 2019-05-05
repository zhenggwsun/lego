package com.zhangweinan.web.controller.sysbench;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.service.ProductService;
import com.zhangweinan.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Eric on 2019/4/17.
 */
@Controller
@RequestMapping("sysbench/product")
public class ProductManageController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "queryProductList", method = RequestMethod.GET)
    public String queryProductList(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Result result = productService.queryProductList(null, pageNum, pageSize);
        request.setAttribute("PaginationModel", result.getData());
        return "/sysbench/product-list";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam(value = "id") Integer id) {
        Result result = productService.delete(id);
        return result;
    }

    @RequestMapping(value = "export", method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "product_info.xls";
        String headStr = "attachment; filename=\"" + fileName + "\"";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", headStr);
        try {
            OutputStream out = response.getOutputStream();
            String[] titles = {"ID", "商品名称", "价格", "产品描述", "分类", "加入时间"};
            Result result = productService.queryProductList();
            HSSFWorkbook workbook = ExcelUtil.createExcel(titles, (List) result.getData());
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("photoImage") MultipartFile photo) {
        String realPath = request.getServletContext().getRealPath("/");
        Result result = productService.upload(realPath, photo);
        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("photo") String photo,
                      @RequestParam("productName") String productName,
                      @RequestParam("category") String category,
                      @RequestParam("price") Double price,
                      @RequestParam("productDesc") String productDesc) {
        String realPath = request.getServletContext().getRealPath("/");
        Result result = productService.addProduct(photo, productName, category, price, productDesc, realPath);
        return result;
    }

    @RequestMapping(value = "queryProductInfo", method = RequestMethod.GET)
    public String queryProductInfo(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("productId") Integer productId) {
        Result result = productService.queryProductInfo(productId);
        request.setAttribute("ProductModel", result.getData());
        return "/sysbench/product-edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("productId") Integer productId,
                      @RequestParam("productName") String productName,
                      @RequestParam("categroy") String category,
                      @RequestParam("price") Double price,
                      @RequestParam("productDesc") String productDesc) {
        Result result = productService.update(productId, productName, category, price, productDesc);
        return result;
    }


}
