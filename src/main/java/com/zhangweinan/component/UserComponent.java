package com.zhangweinan.component;

import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.model.common.PaginationModel;
import com.zhangweinan.model.model.UserAgeChartsModel;
import com.zhangweinan.model.model.UserExportModel;
import com.zhangweinan.model.model.UserModel;
import com.zhangweinan.model.order.UserOrder;
import org.apache.el.parser.BooleanNode;

import java.util.List;

/**
 * Created by Eric on 2019/5/1.
 */
public interface UserComponent {
    /**
     * 登录(普通用户)
     * @param username
     * @return
     */
    public UserDO login(String username, String password);

    /**
     * 登录(管理员)
     * @param username
     * @return
     */
    public UserDO adminLogin(String username, String password);

    /**
     * 注册
     * @param order
     * @return
     */
    public Boolean register(UserOrder order);

    /**
     * 分页查询用户信息
     * @param username
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PaginationModel<UserModel> queryUserList(String username, int pageNum, int pageSize);

    /**
     * 导出用户信息
     * @return
     */
    public List<UserExportModel> queryUserList();

    public UserAgeChartsModel queryAgeCountCharts();
}
