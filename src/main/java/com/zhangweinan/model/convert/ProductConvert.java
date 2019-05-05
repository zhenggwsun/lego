package com.zhangweinan.model.convert;

import com.zhangweinan.dao.objects.AddressDO;
import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.model.model.ProductExportModel;
import com.zhangweinan.model.model.ProductLuceneModel;
import com.zhangweinan.model.order.AddressOrder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 产品模型相关转换
 * Created by Eric on 2019/5/1.
 */
public class ProductConvert {


    public static ProductExportModel convert2ProductExportModel(ProductDO productDO) {
        if (productDO == null){
            return null;
        }
        ProductExportModel productExportModel = new ProductExportModel();
        productExportModel.setId(productDO.getId());
        productExportModel.setCategory(productDO.getCategroy());
        productExportModel.setProductName(productDO.getProductName());
        productExportModel.setProductDesc(productDO.getProductDesc());
        productExportModel.setPrice(productDO.getPrice().doubleValue());
        productExportModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(productDO.getGmtCreate()));
        return productExportModel;
    }

    public static ProductLuceneModel convert2ProductLuceneModel(ProductDO productDO){
        if (productDO == null){
            return null;
        }
        ProductLuceneModel productLuceneModel = new ProductLuceneModel();
        productLuceneModel.setId(productDO.getId());
        productLuceneModel.setPhoto(productDO.getPhoto());
        productLuceneModel.setCategroy(productDO.getCategroy());
        productLuceneModel.setProductName(productDO.getProductName());
        productLuceneModel.setProductDesc(productDO.getProductDesc());
        productLuceneModel.setPrice(productDO.getPrice());
        productLuceneModel.setGmtCreate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(productDO.getGmtCreate()));
        productLuceneModel.setGmtModify(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(productDO.getGmtModify()));
        return productLuceneModel;
    }

}
