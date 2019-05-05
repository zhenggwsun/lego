package com.zhangweinan.service;

import com.zhangweinan.model.common.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Eric on 2019/4/17.
 */
public interface ProductService {
    /**
     * 最新前十
     * @return
     */
    public Result queryNewList();

    /**
     * 爆款推荐(总销量前十)
     * @return
     */
    public Result queryRecommendList();

    /**
     *  当季热卖(最近一个月销量前十)
     * @return
     */
    public Result queryHotSellList();

    /**
     * 查询产品列表
     * @param type
     * @return
     */
    public Result queryProductList(String type, int pageNum, int pageSize);

    /**
     * 分页查询新品
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Result queryNewProductList(int pageNum, int pageSize);

    /**
     * 查询产品信息
     * @param id
     * @return
     */
    public Result queryProductInfo(int id);

    /**
     * 删除产品
     * @param id
     * @return
     */
    public Result delete(Integer id);

    /**
     * 查询产品列表
     * @return
     */
    public Result queryProductList();

    /**
     * 新增
     * @return
     */
    public Result addProduct(String photo, String productName, String category, Double price, String productDesc, String realPath);

    /**
     * 更新
     * @param productId
     * @param productName
     * @param category
     * @param price
     * @param productDesc
     * @return
     */
    public Result update(Integer productId, String productName, String category, Double price, String productDesc);

    /**
     * 上传
     * @param realPath
     * @param photo
     * @return
     */
    public Result upload(String realPath, MultipartFile photo);

    /**
     * 搜索框检索
     * @param key
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Result searchProduct(String key, int pageNum, int pageSize, String realPath);
}
