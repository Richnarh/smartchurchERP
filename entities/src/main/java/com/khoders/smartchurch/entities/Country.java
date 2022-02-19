package com.khoders.smartchurch.entities;

import com.khoders.resource.spring.SpringBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "country")
public class Country  extends SpringBaseModel implements Serializable {
    @Column(name = "country_name")
    private String countryName;

    @Column(name = "country_Code")
    private String countryCode;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
