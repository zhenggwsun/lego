package com.zhangweinan.dao.objects;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_order.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_order.gmt_create
     *
     * @mbggenerated
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_order.gmt_modify
     *
     * @mbggenerated
     */
    private Date gmtModify;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_order.number
     *
     * @mbggenerated
     */
    private Integer number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_order.cost
     *
     * @mbggenerated
     */
    private BigDecimal cost;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_order.product_id
     *
     * @mbggenerated
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_order.address_id
     *
     * @mbggenerated
     */
    private Integer addressId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_order.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lego_order.size
     *
     * @mbggenerated
     */
    private Integer size;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_order.id
     *
     * @return the value of lego_order.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_order.id
     *
     * @param id the value for lego_order.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_order.gmt_create
     *
     * @return the value of lego_order.gmt_create
     *
     * @mbggenerated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_order.gmt_create
     *
     * @param gmtCreate the value for lego_order.gmt_create
     *
     * @mbggenerated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_order.gmt_modify
     *
     * @return the value of lego_order.gmt_modify
     *
     * @mbggenerated
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_order.gmt_modify
     *
     * @param gmtModify the value for lego_order.gmt_modify
     *
     * @mbggenerated
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_order.number
     *
     * @return the value of lego_order.number
     *
     * @mbggenerated
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_order.number
     *
     * @param number the value for lego_order.number
     *
     * @mbggenerated
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_order.cost
     *
     * @return the value of lego_order.cost
     *
     * @mbggenerated
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_order.cost
     *
     * @param cost the value for lego_order.cost
     *
     * @mbggenerated
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_order.product_id
     *
     * @return the value of lego_order.product_id
     *
     * @mbggenerated
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_order.product_id
     *
     * @param productId the value for lego_order.product_id
     *
     * @mbggenerated
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_order.address_id
     *
     * @return the value of lego_order.address_id
     *
     * @mbggenerated
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_order.address_id
     *
     * @param addressId the value for lego_order.address_id
     *
     * @mbggenerated
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_order.user_id
     *
     * @return the value of lego_order.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_order.user_id
     *
     * @param userId the value for lego_order.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lego_order.size
     *
     * @return the value of lego_order.size
     *
     * @mbggenerated
     */
    public Integer getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lego_order.size
     *
     * @param size the value for lego_order.size
     *
     * @mbggenerated
     */
    public void setSize(Integer size) {
        this.size = size;
    }
}