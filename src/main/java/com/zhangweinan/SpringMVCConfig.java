package com.zhangweinan;

import com.zhangweinan.web.intercept.HomeLoginIntercept;
import com.zhangweinan.web.intercept.SysbenchHomeLoginIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Eric on 2019/5/4.
 */
@SpringBootConfiguration
public class SpringMVCConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private HomeLoginIntercept homeLoginIntercept;

    @Autowired
    private SysbenchHomeLoginIntercept sysbenchHomeLoginIntercept;

    private List<String> homePatterns;

    private List<String> sysbenchPatterns;

    private final String[] home = {
            "/home/cart/add",
            "/home/cart/update",
            "/home/cart/delete",
            "/home/cart/showShoppingCart",
            "/home/address/add",
            "/home/address/queryList",
            "/home/order/create",
            "/home/order/show",
    };

    private final String[] sysbench = {
            "/sysbench/user/queryUserList",
            "/sysbench/user/export",
            "/sysbench/repertory/queryList",
            "/sysbench/repertory/delete",
            "/sysbench/repertory/add",
            "/sysbench/repertory/queryInfo",
            "/sysbench/repertory/update",
            "/sysbench/product/queryProductList",
            "/sysbench/product/delete",
            "/sysbench/product/export",
            "/sysbench/product/upload",
            "/sysbench/product/add",
            "/sysbench/product/queryProductInfo",
            "/sysbench/product/update",
            "/sysbench/order/queryOrderList",
            "/sysbench/order/export",
            "/sysbench/index",
            "/sysbench/productAdd",
            "/sysbench/repertoryAdd",
            "/sysbench/echarts1"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        homePatterns = Arrays.asList(home);
        registry.addInterceptor(homeLoginIntercept)
                .addPathPatterns(homePatterns);

        sysbenchPatterns = Arrays.asList(sysbench);
        registry.addInterceptor(sysbenchHomeLoginIntercept)
                .addPathPatterns(sysbenchPatterns);
    }
}
