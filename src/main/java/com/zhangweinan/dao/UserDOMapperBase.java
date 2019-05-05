package com.zhangweinan.dao;

import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.model.model.UserExportModel;
import com.zhangweinan.model.model.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDOMapperBase {
    /**
     * 查询用户
     * @param username
     * @return
     */
    UserDO selectByUsername(@Param("username") String username, @Param("type") String type);

    /**
     * 分页查询用户信息
     * @param username
     * @param from
     * @param pageSize
     * @return
     */
    List<UserModel> selectByPage(@Param("username") String username, @Param("from")int from, @Param("pageSize")int pageSize);

    /**
     * 数量统计
     * @param username
     * @return
     */
    Integer selectCount(@Param("username") String username);

    /**
     * 用户信息获取全部
     * @return
     */
    List<UserExportModel> selectList();
}