package com.zhangweinan.model.model;

import com.zhangweinan.dao.objects.UserDO;
import com.zhangweinan.dao.objects.UserInfoDO;

import java.util.Date;

/**
 * 用户模型
 * Created by Eric on 2019/5/3.
 */
public class UserModel {

    private Integer userId;

    private Date gmtCreate;

    private String username;

    private String password;

    private String type;

    private String displayName;

    private Integer userInfoId;

    private String realName;

    private String sex;

    private Integer age;

    private String tel;

    private String address;

    public UserModel() {
    }

    public UserModel(Integer userId, Date gmtCreate, String username, String password, String type, String displayName, Integer userInfoId, String realName, String sex, Integer age, String tel, String address) {
        this.userId = userId;
        this.gmtCreate = gmtCreate;
        this.username = username;
        this.password = password;
        this.type = type;
        this.displayName = displayName;
        this.userInfoId = userInfoId;
        this.realName = realName;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
