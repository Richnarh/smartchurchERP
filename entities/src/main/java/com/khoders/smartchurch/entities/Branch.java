package com.khoders.smartchurch.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "branches")
public class Branch extends UserAccountRecord implements Serializable {
    @Column(name = "branch_name")
    private String branchName;

    @JoinColumn(name = "head_pastor_name")
    @ManyToOne
    private Membership headPastorName;

    @Column(name = "email")
    private String email;

    @Column(name = "total_members")
    private int totalMembers;

    @Column(name = "password")
    private String password;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Membership getHeadPastorName() {
        return headPastorName;
    }

    public void setHeadPastorName(Membership headPastorName) {
        this.headPastorName = headPastorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
