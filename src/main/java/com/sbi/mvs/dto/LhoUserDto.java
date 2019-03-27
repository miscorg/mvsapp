package com.sbi.mvs.dto;

import java.io.Serializable;

public class LhoUserDto implements Serializable {

    private String networkId;
    private String regionId;
    private String agmatmPF;
    private String chanelManager;
    private String cmcsrrbo;

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAgmatmPF() {
        return agmatmPF;
    }

    public void setAgmatmPF(String agmatmPF) {
        this.agmatmPF = agmatmPF;
    }

    public String getChanelManager() {
        return chanelManager;
    }

    public void setChanelManager(String chanelManager) {
        this.chanelManager = chanelManager;
    }

    public String getCmcsrrbo() {
        return cmcsrrbo;
    }

    public void setCmcsrrbo(String cmcsrrbo) {
        this.cmcsrrbo = cmcsrrbo;
    }
}
