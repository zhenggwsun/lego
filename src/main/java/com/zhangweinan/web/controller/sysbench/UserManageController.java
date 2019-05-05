package com.zhangweinan.web.controller.sysbench;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.model.UserExportModel;
import com.zhangweinan.service.UserService;
import com.zhangweinan.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Eric on 2019/4/17.
 */
@Controller
@RequestMapping("sysbench/user")
public class UserManageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "queryUserList", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){
        Result result = userService.queryUserList(username, pageNum, pageSize);
        request.setAttribute("PaginationModel", result.getData());
        return "/sysbench/user-list";
    }

    @RequestMapping(value = "export", method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response){
        String fileName = "user_info.xls";
        String headStr = "attachment; filename=\"" + fileName + "\"";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", headStr);
        try {
            OutputStream out = response.getOutputStream();
            String[] titles = {"ID","用户名","昵称","真实姓名","性别","手机","地址","加入时间"};
            Result result = userService.queryUserList();
            HSSFWorkbook workbook = ExcelUtil.createExcel(titles, (List) result.getData());
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
