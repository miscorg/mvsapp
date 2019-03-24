package com.sbi.mvs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Pincode implements Serializable {

    @Id
    private String pincode;
    private String officeName;
    private String taluk;
    private String subDistrict;
    private String districtName;
    private String stateName;

    @OneToMany(mappedBy = "pincode")
    private Set<ATM> atmList;

    public String getPincode() {
        return pincode;
    }

    public void setPinCode(String pinCode) {
        this.pincode = pinCode;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }
}
