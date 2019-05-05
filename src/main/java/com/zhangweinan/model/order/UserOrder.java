package com.zhangweinan.model.order;

/**
 * 用户order
 * Created by Eric on 2019/4/23.
 */
public class UserOrder {

    private String realName;

    private String sex;

    private Integer age;

    private String tel;

    private String address;

    private String displayName;

    private String username;

    private String password;

    public UserOrder() {
    }

    public UserOrder(String realName, String sex, Integer age, String tel, String address, String displayName, String username, String password) {
        this.realName = realName;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.address = address;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
}
