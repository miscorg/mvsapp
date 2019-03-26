package com.sbi.mvs.service;

import com.sbi.mvs.entity.LHO;
import com.sbi.mvs.entity.Module;
import com.sbi.mvs.entity.Network;
import com.sbi.mvs.entity.Region;
import com.sbi.mvs.repository.LhoRepository;
import com.sbi.mvs.repository.ModuleRepository;
import com.sbi.mvs.repository.NetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class LhoServiceImpl implements LhoService {

    @Autowired
    LhoRepository lhoRepository;

    @Autowired
    NetworkRepository networkRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Override
    public List<LHO> getAllLho() {
        return lhoRepository.findAll();
    }

    @Override
    public Set<Network> getNetworkByLho(String lhoId) {
        return lhoRepository.findById(lhoId).get().getNetworks();
    }

    @Override
    public Set<Module> getModuleByNetwork(String networkId) {
        return networkRepository.findById(networkId).get().getModules();
    }

    @Override
    public Set<Region> getRegionByModule(String moduleId) {
        Set<Region> regions = moduleRepository.findById(moduleId).get().getRegions();
        return regions;
    }
}
