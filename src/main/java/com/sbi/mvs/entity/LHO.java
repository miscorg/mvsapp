package com.sbi.mvs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
public class LHO implements Serializable {

    @Id
    private String lhoId;
    private String lhoName;

    @JsonIgnore
    @OneToMany( mappedBy = "lho")
    private Set<Network> networks;

    public String getLhoId() {
        return lhoId;
    }

    public void setLhoId(String lhoId) {
        this.lhoId = lhoId;
    }

    public String getLhoName() {
        return lhoName;
    }

    public void setLhoName(String lhoName) {
        this.lhoName = lhoName;
    }

    public Set<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(Set<Network> networks) {
        this.networks = networks;
    }
}
