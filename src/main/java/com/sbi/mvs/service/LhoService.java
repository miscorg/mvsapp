package com.sbi.mvs.service;

import com.sbi.mvs.dto.LhoUserDto;
import com.sbi.mvs.entity.*;

import java.util.List;
import java.util.Set;

public interface LhoService {

    List<LHO> getAllLho();

    Set<Network> getNetworkByLho(String lhoId);

    Set<Module> getModuleByNetwork(String networkId);

    Set<Region> getRegionByModule(String moduleId);

    Pfhrms getPhrmsByType(String type, String id);

    void saveLhoUser(LhoUserDto lhoUser);
}
