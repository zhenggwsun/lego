package com.zhangweinan.component.impl;

import com.zhangweinan.component.CartComponent;
import com.zhangweinan.dao.ProductDOMapper;
import com.zhangweinan.dao.RepertoryDOMapper;
import com.zhangweinan.dao.objects.ProductDO;
import com.zhangweinan.dao.objects.RepertoryDO;
import com.zhangweinan.model.model.CartItemModel;
import com.zhangweinan.model.order.CartOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Eric on 2019/5/1.
 */
@Service("cartComponent")
public class CartComponentImpl implements CartComponent{

    @Autowired
    private ProductDOMapper productDOMapper;

    @Autowired
    private RepertoryDOMapper repertoryDOMapper;

    @Override
    public List<CartItemModel> queryCart(List<CartOrder> list) {
        List<CartItemModel> cartItemModels = new ArrayList<CartItemModel>();
        Iterator<CartOrder> iterator = list.iterator();
        while (iterator.hasNext()){
            CartOrder order = iterator.next();
            ProductDO productDO = productDOMapper.selectByPrimaryKey(order.getProductId());
            RepertoryDO repertoryDO = repertoryDOMapper.selectByProductIdAndSize(order.getProductId(), order.getSize());
            CartItemModel cartItemModel = new CartItemModel(productDO, repertoryDO, order.getNumber());
            cartItemModels.add(cartItemModel);
        }
        return cartItemModels;
    }

    @Override
    public CartItemModel queryCart(CartOrder order) {
        ProductDO productDO = productDOMapper.selectByPrimaryKey(order.getProductId());
        RepertoryDO repertoryDO = repertoryDOMapper.selectByProductIdAndSize(order.getProductId(), order.getSize());
        CartItemModel cartItemModel = new CartItemModel(productDO, repertoryDO, order.getNumber());
        return cartItemModel;
    }
}
