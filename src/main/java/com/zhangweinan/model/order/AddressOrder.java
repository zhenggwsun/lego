package com.zhangweinan.model.order;

/**
 * Created by Eric on 2019/5/2.
 */
public class AddressOrder {

    private String fullName;

    private String tel;

    private String fullAddress;

    private String addressDetail;

    public AddressOrder() {
    }

    public AddressOrder(String fullName, String tel, String fullAddress, String addressDetail) {
        this.fullName = fullName;
        this.tel = tel;
        this.fullAddress = fullAddress;
        this.addressDetail = addressDetail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
}
