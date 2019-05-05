package com.zhangweinan.model.model;

import java.util.Date;

/**
 * Created by Eric on 2019/5/4.
 */
public class UserExportModel {

    private Integer id;

    private String username;

    private String displayName;

    private String realName;

    private String sex;

    private String tel;

    private String address;

    private Date gmtCreate;

    public UserExportModel() {
    }

    public UserExportModel(Integer id, String username, String displayName, String realName, String sex, String tel, String address, Date gmtCreate) {
        this.id = id;
        this.username = username;
        this.displayName = displayName;
        this.realName = realName;
        this.sex = sex;
        this.tel = tel;
        this.address = address;
        this.gmtCreate = gmtCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
