package com.zhangweinan.service.impl;

import com.zhangweinan.component.CartComponent;
import com.zhangweinan.component.OrderComponent;
import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import com.zhangweinan.model.model.*;
import com.zhangweinan.model.order.CartOrder;
import com.zhangweinan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Eric on 2019/4/17.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartComponent cartComponent;

    @Autowired
    private OrderComponent orderComponent;

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Result create(HttpSession session, Integer addressId) {
        Result result = new Result();
        UserDO user = (UserDO) session.getAttribute("user");
        if (user == null){
            throw new WebsiteException(WebsiteCodeEnum.USER_NEDD_LOGIN);
        }
        Map<Integer, List<CartOrder>> cart = (Map<Integer, List<CartOrder>>) session.getAttribute("cart");
        if (!CollectionUtils.isEmpty(cart)) {
            Iterator<Integer> iterator = cart.keySet().iterator();
            while (iterator.hasNext()) {
                Integer productId = iterator.next();
                List<CartOrder> list = cart.get(productId);
                Iterator<CartOrder> iterator1 = list.iterator();
                while (iterator1.hasNext()) {
                    CartOrder cartOrder = iterator1.next();
                    CartItemModel cartItemModel = cartComponent.queryCart(cartOrder);
                    OrderModel orderModel = new OrderModel();
                    orderModel.setProductId(cartItemModel.getProduct().getId());
                    orderModel.setUserId(user.getId());
                    orderModel.setAddressId(addressId);
                    orderModel.setSize(cartItemModel.getRepertory().getSize());
                    orderModel.setNum(cartItemModel.getNum());
                    orderModel.setCost(cartItemModel.getProduct().getPrice().doubleValue() * cartItemModel.getNum());
                    orderComponent.add(orderModel);
                }
            }
        }
        session.removeAttribute("cart");
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result queryOrderList(String start, String end, int pageNum, int pageSize) {
        Result result = new Result();
        Date startDate = null;
        Date endDate = null;
        try {
            if (start != null) {
                startDate = simpleDateFormat.parse(start);
            }
            if (end != null) {
                endDate = simpleDateFormat.parse(end);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PaginationModel<OrderInfoModel> paginationModel = orderComponent.queryOrderList(startDate, endDate, pageNum, pageSize);
        result.fillSuccData(paginationModel);
        return result;
    }

    @Override
    public Result queryOrderList() {
        Result result = new Result();
        List<OrderExportModel> exportModels = orderComponent.queryOrderList();
        result.fillSuccData(exportModels);
        return result;
    }
}
