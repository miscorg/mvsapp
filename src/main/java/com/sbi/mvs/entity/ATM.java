package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ATM implements Serializable {

    @Id
    private String atmId;
    private String atmType;
    private String siteType;
    private String ownershipType;
    private String networkType;
    private String oem;
    private String model;
    private String phase;
    private String msVendor;
    private String cashRepl;
    private boolean status;
    private String address1;
    private String address2;
    private String address3;
    private String village;
    /*private String taluk;
    private String subDistrict;
    private String district;
    private String state;*/
    private String popGroup;
    private String landmark;
    private String os;
    private String supplier;
    private String oldPhase;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ownerBranch")
    private Branch ownerBranch;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cashLinkBranch")
    private Branch cashLinkBranch;

    @ManyToOne
    @JoinColumn(name = "pincode")
    private Pincode pincode;

    public Pincode getPincode() {
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }


//    @JsonIgnore

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ATMNetwork atmNetwork;

//    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ATMAuxInfo atmAuxInfo;

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public String getAtmType() {
        return atmType;
    }

    public void setAtmType(String atmType) {
        this.atmType = atmType;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getMsVendor() {
        return msVendor;
    }

    public void setMsVendor(String msVendor) {
        this.msVendor = msVendor;
    }

    public String getCashRepl() {
        return cashRepl;
    }

    public void setCashRepl(String cashRepl) {
        this.cashRepl = cashRepl;
    }

    public Branch getOwnerBranch() {
        return ownerBranch;
    }

    public void setOwnerBranch(Branch ownerBranch) {
        this.ownerBranch = ownerBranch;
    }

    public Branch getCashLinkBranch() {
        return cashLinkBranch;
    }

    public void setCashLinkBranch(Branch cashLinkBranch) {
        this.cashLinkBranch = cashLinkBranch;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPopGroup() {
        return popGroup;
    }

    public void setPopGroup(String popGroup) {
        this.popGroup = popGroup;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public ATMNetwork getAtmNetwork() {
        return atmNetwork;
    }

    public void setAtmNetwork(ATMNetwork atmNetwork) {
        this.atmNetwork = atmNetwork;
    }

    public ATMAuxInfo getAtmAuxInfo() {
        return atmAuxInfo;
    }

    public void setAtmAuxInfo(ATMAuxInfo atmAuxInfo) {
        this.atmAuxInfo = atmAuxInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ATM{");
        sb.append("atmId='").append(atmId).append('\'');
        sb.append(", atmType='").append(atmType).append('\'');
        sb.append(", siteType='").append(siteType).append('\'');
        sb.append(", ownershipType='").append(ownershipType).append('\'');
        sb.append(", networkType='").append(networkType).append('\'');
        sb.append(", oem='").append(oem).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", phase='").append(phase).append('\'');
        sb.append(", msVendor='").append(msVendor).append('\'');
        sb.append(", cashRepl='").append(cashRepl).append('\'');
        sb.append(", ownerBranch=").append(ownerBranch);
        sb.append(", cashLinkBranch=").append(cashLinkBranch);
        sb.append(", address1='").append(address1).append('\'');
        sb.append(", address2='").append(address2).append('\'');
        sb.append(", address3='").append(address3).append('\'');
        sb.append(", village='").append(village).append('\'');
        sb.append(", popGroup='").append(popGroup).append('\'');
        sb.append(", landmark='").append(landmark).append('\'');
        sb.append(", atmNetwork=").append(atmNetwork);
        sb.append(", atmAuxInfo=").append(atmAuxInfo);
        sb.append('}');
        return sb.toString();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getOldPhase() {
        return oldPhase;
    }

    public void setOldPhase(String oldPhase) {
        this.oldPhase = oldPhase;
    }
}

