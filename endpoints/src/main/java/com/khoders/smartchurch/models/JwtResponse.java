package com.khoders.smartchurch.models;

import com.khoders.smartchurch.entities.UserAccount;

public class JwtResponse {
    private UserAccount userAccount;
    private String jwtToken;

    public JwtResponse(UserAccount userAccount, String jwtToken) {
        this.userAccount = userAccount;
        this.jwtToken = jwtToken;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
