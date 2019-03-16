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

    @MapsId
    @OneToOne(mappedBy = "lhoPeopleData")
    @JoinColumn(name = "networkId")
    private Network network;

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

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}
