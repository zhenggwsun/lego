package com.zhangweinan.dao.objects;

import java.util.Date;

public class AddressDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_address.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_address.gmt_create
     *
     * @mbggenerated
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_address.gmt_modify
     *
     * @mbggenerated
     */
    private Date gmtModify;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_address.full_name
     *
     * @mbggenerated
     */
    private String fullName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_address.tel
     *
     * @mbggenerated
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_address.full_address
     *
     * @mbggenerated
     */
    private String fullAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_address.address_detail
     *
     * @mbggenerated
     */
    private String addressDetail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_address.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_address.id
     *
     * @return the value of lego_address.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_address.id
     *
     * @param id the value for lego_address.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_address.gmt_create
     *
     * @return the value of lego_address.gmt_create
     *
     * @mbggenerated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_address.gmt_create
     *
     * @param gmtCreate the value for lego_address.gmt_create
     *
     * @mbggenerated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_address.gmt_modify
     *
     * @return the value of lego_address.gmt_modify
     *
     * @mbggenerated
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_address.gmt_modify
     *
     * @param gmtModify the value for lego_address.gmt_modify
     *
     * @mbggenerated
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_address.full_name
     *
     * @return the value of lego_address.full_name
     *
     * @mbggenerated
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_address.full_name
     *
     * @param fullName the value for lego_address.full_name
     *
     * @mbggenerated
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_address.tel
     *
     * @return the value of lego_address.tel
     *
     * @mbggenerated
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_address.tel
     *
     * @param tel the value for lego_address.tel
     *
     * @mbggenerated
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_address.full_address
     *
     * @return the value of lego_address.full_address
     *
     * @mbggenerated
     */
    public String getFullAddress() {
        return fullAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_address.full_address
     *
     * @param fullAddress the value for lego_address.full_address
     *
     * @mbggenerated
     */
    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress == null ? null : fullAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_address.address_detail
     *
     * @return the value of lego_address.address_detail
     *
     * @mbggenerated
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_address.address_detail
     *
     * @param addressDetail the value for lego_address.address_detail
     *
     * @mbggenerated
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_address.user_id
     *
     * @return the value of lego_address.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_address.user_id
     *
     * @param userId the value for lego_address.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}