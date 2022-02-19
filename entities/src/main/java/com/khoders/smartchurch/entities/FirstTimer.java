package com.khoders.smartchurch.entities;

import com.khoders.smartchurch.enums.Reason;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "first_timers")
public class FirstTimer extends UserAccountRecord implements Serializable {
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "reason")
    @Enumerated(EnumType.STRING)
    private Reason reason;

    @Lob
    @Column(name = "description")
    private String description;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
