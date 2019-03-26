package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LHOPeopleData implements Serializable {

    @Id
    private String networkId;

    @OneToOne
    @JoinColumn(name = "agmatmPFId")
    private Pfhrms agmatmPF;


    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public Pfhrms getAgmatmPF() {
        return agmatmPF;
    }

    public void setAgmatmPF(Pfhrms agmatmPF) {
        this.agmatmPF = agmatmPF;
    }

}
