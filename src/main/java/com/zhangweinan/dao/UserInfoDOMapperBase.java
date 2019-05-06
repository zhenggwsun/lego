package com.zhangweinan.dao;

import com.zhangweinan.dao.objects.UserInfoDO;
import com.zhangweinan.model.model.UserAgeChartsModel;

import java.util.List;

public interface UserInfoDOMapperBase {

    public int selectCountAgeltTwenty();
    public int selectCountAgeTwentyToForty();
    public int selectCountAgeFortyToSixty();
    public int selectCountAgegtSixty();

}