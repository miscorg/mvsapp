package com.sbi.mvs.dto;

import java.io.Serializable;

public class DashboardDTO implements Serializable {

    private String lho;
    private String totalATM;
    private String verifiedATM;
    private String endingATM;

    public String getLho() {
        return lho;
    }

    public void setLho(String lho) {
        this.lho = lho;
    }

    public String getTotalATM() {
        return totalATM;
    }

    public void setTotalATM(String totalATM) {
        this.totalATM = totalATM;
    }

    public String getVerifiedATM() {
        return verifiedATM;
    }

    public void setVerifiedATM(String verifiedATM) {
        this.verifiedATM = verifiedATM;
    }

    public String getEndingATM() {
        return endingATM;
    }

    public void setEndingATM(String endingATM) {
        this.endingATM = endingATM;
    }
}
