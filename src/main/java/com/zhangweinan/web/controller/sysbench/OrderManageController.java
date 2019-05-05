package com.zhangweinan.web.controller.sysbench;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.service.OrderService;
import com.zhangweinan.service.UserService;
import com.zhangweinan.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by Eric on 2019/4/17.
 */
@Controller
@RequestMapping("sysbench/order")
public class OrderManageController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "queryOrderList", method = RequestMethod.GET)
    public String queryOrderList(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "startDate", required = false) String start,
                        @RequestParam(value = "endDate", required = false) String end,
                        @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){
        Result result = orderService.queryOrderList(start, end, pageNum, pageSize);
        request.setAttribute("PaginationModel", result.getData());
        return "/sysbench/order-list";
    }

    @RequestMapping(value = "export", method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response){
        String fileName = "order_info.xls";
        String headStr = "attachment; filename=\"" + fileName + "\"";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", headStr);
        try {
            OutputStream out = response.getOutputStream();
            String[] titles = {"ID","商品名称","鞋码","数量","总价","地址","下单时间","所属用户"};
            Result result = orderService.queryOrderList();
            HSSFWorkbook workbook = ExcelUtil.createExcel(titles, (List) result.getData());
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
