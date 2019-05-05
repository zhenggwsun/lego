package com.zhangweinan.service.impl;

import com.zhangweinan.component.ProductComponent;
import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.enums.ProductTypeEnum;
import com.zhangweinan.model.model.ProductExportModel;
import com.zhangweinan.model.model.ProductLuceneModel;
import com.zhangweinan.model.model.ProductModel;
import com.zhangweinan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.zhangweinan.model.convert.ProductConvert.convert2ProductLuceneModel;

/**
 * Created by Eric on 2019/4/17.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductComponent productComponent;

    @Override
    public Result queryNewList() {
        Result result = new Result();
        List<ProductDO> productDOS = productComponent.queryNewTen();
        result.fillSuccData(productDOS);
        return result;
    }

    @Override
    public Result queryRecommendList() {
        Result result = new Result();
        List<ProductDO> productDOS = productComponent.queryRecommendList();
        result.fillSuccData(productDOS);
        return result;
    }

    @Override
    public Result queryHotSellList() {
        Result result = new Result();
        List<ProductDO> productDOS = productComponent.queryHotSellList();
        result.fillSuccData(productDOS);
        return result;
    }

    @Override
    public Result queryProductList(String type, int pageNum, int pageSize) {
        Result result = new Result();
        PaginationModel<ProductDO> paginationModel = productComponent.queryProductList(ProductTypeEnum.getByType(type),pageNum, pageSize);
        result.fillSuccData(paginationModel);
        return result;
    }

    @Override
    public Result queryNewProductList(int pageNum, int pageSize) {
        Result result = new Result();
        PaginationModel<ProductDO> paginationModel = productComponent.queryNewProductList(pageNum, pageSize);
        result.fillSuccData(paginationModel);
        return result;
    }

    @Override
    public Result queryProductInfo(int id) {
        Result result = new Result();
        ProductModel productModel = productComponent.queryProductInfo(id);
        result.fillSuccData(productModel);
        return result;
    }

    @Override
    public Result delete(Integer id) {
        Result result = new Result();
        Boolean success = productComponent.delete(id);
        result.setSuccess(success);
        return result;
    }

    @Override
    public Result queryProductList() {
        Result result = new Result();
        List<ProductExportModel> productExportModels = productComponent.queryProductList();
        result.fillSuccData(productExportModels);
        return result;
    }

    @Override
    public Result addProduct(String photo, String productName, String category, Double price, String productDesc, String realPath) {
        Result result = new Result();
        //保存,存储至数据库
        ProductDO productDO = new ProductDO();
        productDO.setPhoto(photo);
        productDO.setProductName(productName);
        productDO.setCategroy(category);
        productDO.setPrice(new BigDecimal(price));
        productDO.setProductDesc(productDesc);
        productDO.setGmtCreate(new Date());
        productDO.setGmtModify(new Date());
        Boolean success = productComponent.add(productDO);

        if (success){
            //存储至lucene索引库
            ProductLuceneModel productLuceneModel = convert2ProductLuceneModel(productDO);
            Boolean luceneSuccess = productComponent.addToLucene(productLuceneModel, realPath);
            result.setSuccess(luceneSuccess);
        }

        return result;
    }

    @Override
    public Result update(Integer productId, String productName, String category, Double price, String productDesc) {
        Result result = new Result();
        //保存
        ProductDO productDO = new ProductDO();
        productDO.setId(productId);
        productDO.setProductName(productName);
        productDO.setCategroy(category);
        productDO.setPrice(new BigDecimal(price));
        productDO.setProductDesc(productDesc);
        productDO.setGmtModify(new Date());
        Boolean success = productComponent.update(productDO);
        result.setSuccess(success);
        return result;
    }

    @Override
    public Result upload(String realPath, MultipartFile photo) {
        Result result = new Result();
        //上传图片，并获取路径
        String path = uploadFile(photo, realPath);
        result.fillSuccData(path);
        return result;
    }

    @Override
    public Result searchProduct(String key, int pageNum, int pageSize, String realPath) {
        Result result = new Result();
//        PaginationModel<ProductDO> productDOS = productComponent.searchProduct(key, pageNum, pageSize);
        List<ProductLuceneModel> productDOS = productComponent.searchProduct(key, pageNum, pageSize, realPath);
        result.fillSuccData(productDOS);
        return result;
    }

    private String uploadFile(MultipartFile file, String realPath) {
        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = realPath + "uploaded" + File.separator + fileName;
            File destFile = new File(destFileName);
            file.transferTo(destFile);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
