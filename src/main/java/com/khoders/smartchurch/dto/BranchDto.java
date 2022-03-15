package com.khoders.smartchurch.dto;

import com.khoders.smartchurch.entities.Membership;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BranchDto {
    private String branchName;
    private String headPastorName;
    private String headPastorId;
    private String email;
    private int totalMembers;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getHeadPastorName() {
        return headPastorName;
    }

    public void setHeadPastorName(String headPastorName) {
        this.headPastorName = headPastorName;
    }

    public String getHeadPastorId() {
        return headPastorId;
    }

    public void setHeadPastorId(String headPastorId) {
        this.headPastorId = headPastorId;
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
}
