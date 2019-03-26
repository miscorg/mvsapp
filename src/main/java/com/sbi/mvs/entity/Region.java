package com.sbi.mvs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Region implements Serializable {

    @Id
    private String regionId;
    private String regionName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "moduleId")
    private Module module;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "regionId")
    private RegionPeopleData regionPeopleData;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public RegionPeopleData getRegionPeopleData() {
        return regionPeopleData;
    }

    public void setRegionPeopleData(RegionPeopleData regionPeopleData) {
        this.regionPeopleData = regionPeopleData;
    }
}
