package com.zhangweinan.component;

import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.enums.ProductTypeEnum;
import com.zhangweinan.model.model.ProductExportModel;
import com.zhangweinan.model.model.ProductLuceneModel;
import com.zhangweinan.model.model.ProductModel;
import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;

import java.util.List;

/**
 * 产品组件
 * Created by Eric on 2019/4/17.
 */
public interface ProductComponent {
    /**
     * 新品上市(最新前十)
     * @return
     */
    public List<ProductDO> queryNewTen();

    /**
     * 爆款推荐(总销量前十)
     * @return
     */
    public List<ProductDO> queryRecommendList();

    /**
     *  当季热卖(最近一个月销量前十)
     * @return
     */
    public List<ProductDO> queryHotSellList();

    /**
     * 根据类型查询产品列表并实现分页
     * @param type
     * @return
     */
    public PaginationModel<ProductDO> queryProductList(ProductTypeEnum type, int pageNum, int pageSize);

    /**
     * 查询最新100
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PaginationModel<ProductDO> queryNewProductList(int pageNum, int pageSize);

    /**
     * 查询产品信息
     * @param id
     * @return
     */
    public ProductModel queryProductInfo(int id);

    /**
     * 删除产品
     * @param id
     * @return
     */
    public Boolean delete(Integer id);

    /**
     * 查询产品导出列表
     * @return
     */
    public List<ProductExportModel> queryProductList();

    /**
     * 新增
     * @param productDO
     * @return
     */
    public Boolean add(ProductDO productDO);

    /**
     * 新增至lucene索引库
     * @param productLuceneModel
     * @return
     */
    public Boolean addToLucene(ProductLuceneModel productLuceneModel, String realPath);

    /**
     * 更新
     * @param productDO
     * @return
     */
    public Boolean update(ProductDO productDO);

    /**
     * 列表检索
     * @param key
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PaginationModel<ProductDO> searchProduct(String key, int pageNum, int pageSize);
    public List<ProductLuceneModel> searchProduct(String key, int pageNum, int pageSize, String realPath);
}
