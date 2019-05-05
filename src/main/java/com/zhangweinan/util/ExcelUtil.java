package com.zhangweinan.util;

import com.zhangweinan.model.model.OrderExportModel;
import com.zhangweinan.model.model.ProductExportModel;
import com.zhangweinan.model.model.UserExportModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Eric on 2019/5/4.
 */
public class ExcelUtil {
    /**
     * 构建HSSFWorkbook
     * @param title
     * @param values
     * @return
     */
    public static HSSFWorkbook createExcel(String[] title, List values) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        //title
        HSSFRow firstRow = sheet.createRow(0);
        for (int i = 0; i < title.length; i++) {
            firstRow.createCell(i).setCellValue(title[i]);
        }
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            HSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
            Object next = iterator.next();
            if (next instanceof UserExportModel){
                UserExportModel model = (UserExportModel) next;
                Field[] fields = model.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    //设置是否允许访问，不是修改原来的访问权限修饰词。
                    try {
                        fields[i].setAccessible(true);
                        row.createCell(i).setCellValue(String.valueOf(fields[i].get(model)));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }else if (next instanceof OrderExportModel){
                OrderExportModel model = (OrderExportModel) next;
                Field[] fields = model.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    //设置是否允许访问，不是修改原来的访问权限修饰词。
                    try {
                        fields[i].setAccessible(true);
                        row.createCell(i).setCellValue(String.valueOf(fields[i].get(model)));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }else if (next instanceof ProductExportModel){
                ProductExportModel model = (ProductExportModel) next;
                Field[] fields = model.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    //设置是否允许访问，不是修改原来的访问权限修饰词。
                    try {
                        fields[i].setAccessible(true);
                        row.createCell(i).setCellValue(String.valueOf(fields[i].get(model)));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return workbook;
    }

}
