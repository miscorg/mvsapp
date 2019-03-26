package com.sbi.mvs.service;

import com.sbi.mvs.entity.LHO;
import com.sbi.mvs.entity.Module;
import com.sbi.mvs.entity.Network;
import com.sbi.mvs.entity.Region;

import java.util.List;
import java.util.Set;

public interface LhoService {

    List<LHO> getAllLho();

    Set<Network> getNetworkByLho(String lhoId);

    Set<Module> getModuleByNetwork(String networkId);

    Set<Region> getRegionByModule(String moduleId);
}
