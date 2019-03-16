package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Module implements Serializable {

    @Id
    private String moduleId;
    private String moduleName;

    @ManyToOne
    @JoinColumn(name = "networkId")
    private Network network;

    @OneToMany(mappedBy = "module")
    private Set<Region> regions;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }
}
