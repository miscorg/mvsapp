package com.sbi.mvs.dto;

import java.io.Serializable;

public class DashboardDTO implements Serializable {

    private String lho;
    private Long totalATM;
    private Long verifiedATM;
    private Long endingATM;

    public DashboardDTO(String lho, Long totalATM, Long verifiedATM, Long endingATM) {
        this.lho = lho;
        this.totalATM = totalATM;
        this.verifiedATM = verifiedATM;
        this.endingATM = endingATM;
    }

    public DashboardDTO(){}

    public String getLho() {

        return lho;
    }

    public void setLho(String lho) {
        this.lho = lho;
    }

    public Long getTotalATM() {
        return totalATM;
    }

    public void setTotalATM(Long totalATM) {
        this.totalATM = totalATM;
    }

    public Long getVerifiedATM() {
        return verifiedATM;
    }

    public void setVerifiedATM(Long verifiedATM) {
        this.verifiedATM = verifiedATM;
    }

    public Long getEndingATM() {
        return endingATM;
    }

    public void setEndingATM(Long endingATM) {
        this.endingATM = endingATM;
    }
}
