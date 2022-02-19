package com.khoders.smartchurch.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ministries")
public class Ministries extends UserAccountRecord implements Serializable {
    @Column(name = "ministry_name")
    private String ministryName;

    @JoinColumn(name = "leader", referencedColumnName = "id")
    @ManyToOne
    private Membership leader;

    @JoinColumn(name = "assistance", referencedColumnName = "id")
    @ManyToOne
    private Membership assistance;

    @JoinColumn(name = "overseer", referencedColumnName = "id")
    @ManyToOne
    private Membership overseer;

    @Column(name = "total_members")
    private int totalMembers;

    @Lob
    @Column(name = "description")
    private String description;

    public String getMinistryName() {
        return ministryName;
    }

    public void setMinistryName(String ministryName) {
        this.ministryName = ministryName;
    }

    public Membership getLeader() {
        return leader;
    }

    public void setLeader(Membership leader) {
        this.leader = leader;
    }

    public Membership getAssistance() {
        return assistance;
    }

    public void setAssistance(Membership assistance) {
        this.assistance = assistance;
    }

    public Membership getOverseer() {
        return overseer;
    }

    public void setOverseer(Membership overseer) {
        this.overseer = overseer;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
