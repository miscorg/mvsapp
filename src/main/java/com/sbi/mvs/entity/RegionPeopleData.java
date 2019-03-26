package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class RegionPeopleData implements Serializable {

    @Id
    private String regionId;

    @OneToOne
    @JoinColumn(name = "chanelManagerPFId")
    private Pfhrms chanelManager;

    @OneToOne
    @JoinColumn(name = "cmcsrrboPFId")
    private Pfhrms cmcsrrbo;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Pfhrms getChanelManager() {
        return chanelManager;
    }

    public void setChanelManager(Pfhrms chanelManager) {
        this.chanelManager = chanelManager;
    }

    public Pfhrms getCmcsrrbo() {
        return cmcsrrbo;
    }

    public void setCmcsrrbo(Pfhrms cmcsrrbo) {
        this.cmcsrrbo = cmcsrrbo;
    }

}
