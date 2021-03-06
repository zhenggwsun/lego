package com.zhangweinan.dao;

import com.zhangweinan.dao.objects.UserDO;
import java.util.List;

public interface UserDOMapper extends UserDOMapperBase{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lego_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lego_user
     *
     * @mbggenerated
     */
    int insert(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lego_user
     *
     * @mbggenerated
     */
    UserDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lego_user
     *
     * @mbggenerated
     */
    List<UserDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lego_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserDO record);
}