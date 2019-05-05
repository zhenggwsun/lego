package com.zhangweinan.component.impl;

import com.zhangweinan.component.ProductComponent;
import com.zhangweinan.dao.ProductDOMapper;
import com.zhangweinan.dao.RepertoryDOMapper;
import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.dao.objects.RepertoryDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.enums.ProductTypeEnum;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import com.zhangweinan.model.model.ProductExportModel;
import com.zhangweinan.model.model.ProductLuceneModel;
import com.zhangweinan.model.model.ProductModel;
import com.zhangweinan.util.LuceneUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.zhangweinan.model.convert.ProductConvert.convert2ProductExportModel;

/**
 * Created by Eric on 2019/4/17.
 */
@Service("productComponent")
public class ProductComponentImpl implements ProductComponent{

    @Autowired
    private ProductDOMapper productDOMapper;

    @Autowired
    private RepertoryDOMapper repertoryDOMapper;

    @Override
    public List<ProductDO> queryNewTen() {
        return productDOMapper.selectNewTen();
    }

    @Override
    public List<ProductDO> queryRecommendList() {
        return productDOMapper.selectSellMostTen();
    }

    @Override
    public List<ProductDO> queryHotSellList() {
        return productDOMapper.selectSellMostTenInMonth();
    }

    @Override
    public PaginationModel<ProductDO> queryProductList(ProductTypeEnum type, int pageNum, int pageSize) {
        PaginationModel<ProductDO> paginationModel = new PaginationModel<>();

        int from = (pageNum -1)*pageSize;
        String typeStr = null;
        if (type != null){
            typeStr = type.getDesc();
        }
        List<ProductDO> productDOS = productDOMapper.selectProductList(typeStr, from, pageSize);
        int total = productDOMapper.selectProductListCount(typeStr);

        paginationModel.setList(productDOS);
        paginationModel.setTotal(total);
        paginationModel.fillPageModel(pageNum, pageSize, total);
        return paginationModel;
    }

    @Override
    public PaginationModel<ProductDO> queryNewProductList(int pageNum, int pageSize) {
        PaginationModel<ProductDO> paginationModel = new PaginationModel<>();

        int from = (pageNum -1)*pageSize;
        List<ProductDO> productDOS = productDOMapper.selectNewProductList(from, pageSize);
        int total = productDOMapper.selectCount();

        if (total > 100){
            total = 100;
        }
        paginationModel.setList(productDOS);
        paginationModel.setTotal(total);
        paginationModel.fillPageModel(pageNum, pageSize, total);
        return paginationModel;
    }

    @Override
    public ProductModel queryProductInfo(int id) {
        ProductModel productModel = new ProductModel();

        ProductDO productDO = productDOMapper.selectByPrimaryKey(id);
        List<RepertoryDO> repertoryDOS = repertoryDOMapper.selectByProductId(id);

        productModel.setProduct(productDO);
        productModel.setRepertory(repertoryDOS);
        return productModel;
    }

    @Override
    public Boolean delete(Integer id) {
        int i = productDOMapper.deleteByPrimaryKey(id);
        if (i < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        return true;
    }

    @Override
    public List<ProductExportModel> queryProductList() {
        ArrayList<ProductExportModel> list = new ArrayList<>();
        List<ProductDO> productDOS = productDOMapper.selectAll();
        if (!CollectionUtils.isEmpty(productDOS)){
            Iterator<ProductDO> iterator = productDOS.iterator();
            while (iterator.hasNext()){
                ProductDO productDO = iterator.next();
                ProductExportModel productExportModel = convert2ProductExportModel(productDO);
                list.add(productExportModel);
            }
        }
        return list;
    }

    @Override
    public Boolean add(ProductDO productDO) {
        int i = productDOMapper.insert(productDO);
        if (i < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean addToLucene(ProductLuceneModel model, String realPath) {
        //把数据填充到JavaBean对象中
        Document document = LuceneUtils.javaBean2Document(model);
        /**
         * IndexWriter将我们的document对象写到硬盘中
         *
         * 参数一：Directory d,写到硬盘中的目录路径是什么
         * 参数二：Analyzer a, 以何种算法来对document中的原始记录表数据进行拆分成词汇表
         * 参数三：MaxFieldLength mfl 最多将文本拆分出多少个词汇
         *
         * */
        IndexWriter indexWriter = null;
        try {
            indexWriter = new IndexWriter(LuceneUtils.getDirectory(realPath), LuceneUtils.getAnalyzer(), LuceneUtils.getMaxFieldLength());
            //将Document对象通过IndexWriter对象写入索引库中
            indexWriter.addDocument(document);
            //关闭IndexWriter对象
            indexWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(ProductDO productDO) {
        ProductDO product = productDOMapper.selectByPrimaryKey(productDO.getId());
        if (product == null){
            throw new WebsiteException(WebsiteCodeEnum.PRODUCT_NOT_EXIST);
        }
        productDO.setGmtCreate(product.getGmtCreate());
        productDO.setPhoto(product.getPhoto());
        int i = productDOMapper.updateByPrimaryKey(productDO);
        if (i < 1){
            throw new WebsiteException(WebsiteCodeEnum.DATABASE_OPERATE_ERROR);
        }
        return true;
    }

    @Override
    public PaginationModel<ProductDO> searchProduct(String key, int pageNum, int pageSize) {
        //key模糊匹配
        PaginationModel<ProductDO> paginationModel = new PaginationModel<>();

        int from = (pageNum -1)*pageSize;
        List<ProductDO> productDOS = productDOMapper.selectByKey(key, from, pageSize);
        Integer total = productDOMapper.selectByKeyCount(key);

        paginationModel.setList(productDOS);
        paginationModel.setTotal(total);
        paginationModel.fillPageModel(pageNum, pageSize, total);
        return paginationModel;
    }

    public List<ProductLuceneModel> searchProduct(String key, int pageNum, int pageSize, String realPath) {
        //key模糊匹配
        List<ProductLuceneModel> list = new ArrayList<ProductLuceneModel>();
        try {
            //创建IndexSearcher对象
            IndexSearcher indexSearcher = new IndexSearcher(LuceneUtils.getDirectory(realPath));
            //创建QueryParser对象
            QueryParser queryParser = new QueryParser(Version.LUCENE_30, "productName", LuceneUtils.getAnalyzer());
            //给出要查询的关键字
            //创建Query对象来封装关键字
            Query query = queryParser.parse(key);
            //用IndexSearcher对象去索引库中查询符合条件的前100条记录，不足100条记录的以实际为准
            TopDocs topDocs = indexSearcher.search(query, 20);

            //设置关键字高亮
            Formatter formatter = new SimpleHTMLFormatter("<font color='red'>","</font>");
            Scorer scorer = new QueryScorer(query);
            Highlighter highlighter = new Highlighter(formatter,scorer);
            //获取符合条件的编号
            for (int i = 0; i < topDocs.scoreDocs.length; i++) {
                ScoreDoc scoreDoc = topDocs.scoreDocs[i];
                int no = scoreDoc.doc;
                //用indexSearcher对象去索引库中查询编号对应的Document对象
                Document document = indexSearcher.doc(no);
                //设置内容高亮
                String highlighterContent = highlighter.getBestFragment(LuceneUtils.getAnalyzer(),"productName",document.get("productName"));
                document.getField("productName").setValue(highlighterContent);
                //将Document对象中的所有属性取出，再封装回JavaBean对象中去
                ProductLuceneModel productDO = (ProductLuceneModel) LuceneUtils.Document2JavaBean(document, ProductLuceneModel.class);
                list.add(productDO);
            }
        }catch (Exception e){
            throw new WebsiteException(WebsiteCodeEnum.SYSTEM_ERROR);
        }

        return list;
    }
}
