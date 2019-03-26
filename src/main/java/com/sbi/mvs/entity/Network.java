package com.sbi.mvs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Network implements Serializable {

    @Id
    private String networkId;
    private String networkName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lhoId")
    @Where(clause = "")
    private LHO lho;

    @JsonIgnore
    @OneToMany(mappedBy = "network")
    private Set<Module> modules;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "networkId")
    private LHOPeopleData lhoPeopleData;

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public LHO getLho() {
        return lho;
    }

    public void setLho(LHO lho) {
        this.lho = lho;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public LHOPeopleData getLhoPeopleData() {
        return lhoPeopleData;
    }

    public void setLhoPeopleData(LHOPeopleData lhoPeopleData) {
        this.lhoPeopleData = lhoPeopleData;
    }
}
