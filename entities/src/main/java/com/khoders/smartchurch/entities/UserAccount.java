package com.khoders.smartchurch.entities;

import com.khoders.resource.spring.SpringBaseModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user_account")
public class UserAccount extends SpringBaseModel implements Serializable {
    @Column(name = "church_name")
    private String churchName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "head_pastor_name")
    private String headPastorName;

    @JoinColumn(name = "country", referencedColumnName = "id")
    @ManyToOne
    private Country country;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private Set<Role> role;

    @Column(name = "discount_Code")
    private String discountCode;

    @Column(name = "password")
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
