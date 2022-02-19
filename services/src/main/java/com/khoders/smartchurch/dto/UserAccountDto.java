package com.khoders.smartchurch.dto;

import javax.persistence.Column;

public class UserAccountDto {
    private String churchName;
    private String emailAddress;
    private String headPastorName;
    private String countryName;
    private String countryId;
    private String discountCode;
    private String password;

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHeadPastorName() {
        return headPastorName;
    }

    public void setHeadPastorName(String headPastorName) {
        this.headPastorName = headPastorName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
