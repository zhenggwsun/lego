package com.zhangweinan.dao;

import com.zhangweinan.dao.objects.AddressDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDOMapperBase {

    public List<AddressDO> selectByUserId(@Param("userId") Integer userId);
}