package com.zhangweinan.service.impl;

import com.zhangweinan.component.CartComponent;
import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.model.CartItemModel;
import com.zhangweinan.model.model.CartModel;
import com.zhangweinan.model.order.CartOrder;
import com.zhangweinan.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Eric on 2019/4/17.
 */
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private CartComponent cartComponent;

    @Override
    public Result add(HttpSession session, CartOrder order) {
        Result result = new Result();
        Map<Integer, List<CartOrder>> cart = (Map<Integer, List<CartOrder>>) session.getAttribute("cart");
        List<CartOrder> list;
        if (cart == null){
            //购物车为空
            cart = new HashMap<Integer, List<CartOrder>>();
            list = new ArrayList<CartOrder>();
            list.add(order);
            cart.put(order.getProductId(), list);
            session.setAttribute("cart", cart);
        }else{
            //已有购物车
            list = cart.get(order.getProductId());
            if (CollectionUtils.isEmpty(list)){
                list = new ArrayList<CartOrder>();
                list.add(order);
                cart.put(order.getProductId(), list);
            }else {
                boolean has = false;
                Iterator<CartOrder> iterator = list.iterator();
                while (iterator.hasNext()){
                    CartOrder cartOrder = iterator.next();
                    //比较size
                    if (cartOrder.getSize().equals(order.getSize())){
                        cartOrder.setNumber(cartOrder.getNumber()+order.getNumber());
                        has = true;
                        break;
                    }
                }
                if (!has){
                    list.add(order);
                }
            }
        }
        result.fillSuccData(true);
        return result;
    }

    @Override
    public Result update(HttpSession session, CartOrder order) {
        Result result = new Result();
        Map<Integer, List<CartOrder>> cart = (Map<Integer, List<CartOrder>>) session.getAttribute("cart");
        List<CartOrder> list;
        if (cart != null){
            //已有购物车
            list = cart.get(order.getProductId());
            if (!CollectionUtils.isEmpty(list)){
                Iterator<CartOrder> iterator = list.iterator();
                while (iterator.hasNext()){
                    CartOrder cartOrder = iterator.next();
                    //比较size
                    if (cartOrder.getSize().equals(order.getSize())){
                        cartOrder.setNumber(order.getNumber());
                        break;
                    }
                }
            }
        }
        result.fillSuccData(true);
        return result;
    }

    @Override
    public Result delete(HttpSession session, CartOrder order) {
        Result result = new Result();
        Map<Integer, List<CartOrder>> cart = (Map<Integer, List<CartOrder>>) session.getAttribute("cart");
        List<CartOrder> list;
        if (cart != null){
            //已有购物车
            list = cart.get(order.getProductId());
            if (!CollectionUtils.isEmpty(list)){
                Iterator<CartOrder> iterator = list.iterator();
                while (iterator.hasNext()){
                    CartOrder cartOrder = iterator.next();
                    //比较size
                    if (cartOrder.getSize().equals(order.getSize())){
                        iterator.remove();
                        break;
                    }
                }
            }
        }
        result.fillSuccData(true);
        return result;
    }

    @Override
    public Result show(HttpSession session) {
        Result result = new Result();
        CartModel cartModel = new CartModel();
        Map<Integer, List<CartOrder>> cart = (Map<Integer, List<CartOrder>>) session.getAttribute("cart");
        if (!CollectionUtils.isEmpty(cart)){
            //如果购物车不为空
            List<CartOrder> list = new ArrayList<>();
            Iterator<List<CartOrder>> iterator = cart.values().iterator();
            while (iterator.hasNext()){
                List<CartOrder> next = iterator.next();
                list.addAll(next);
            }
            List<CartItemModel> cartItemModels = cartComponent.queryCart(list);
            //总价
            Double total = 0D;
            Iterator<CartItemModel> iterator1 = cartItemModels.iterator();
            while(iterator1.hasNext()){
                CartItemModel model = iterator1.next();
                BigDecimal price = model.getProduct().getPrice();
                Integer num = model.getNum();
                total += price.doubleValue()* num;
            }
            cartModel.setList(cartItemModels);
            cartModel.setTotal(total);
        }
        result.fillSuccData(cartModel);
        return result;
    }
}
