package com.khoders.smartchurch.entities;

import com.khoders.resource.spring.SpringBaseModel;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class UserAccountRecord extends SpringBaseModel {
    @JoinColumn(name = "user_account", referencedColumnName = "id")
    @ManyToOne
    private UserAccount userAccount;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
