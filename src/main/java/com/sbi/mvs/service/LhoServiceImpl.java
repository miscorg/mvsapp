package com.sbi.mvs.service;

import com.sbi.mvs.entity.*;
import com.sbi.mvs.repository.LhoRepository;
import com.sbi.mvs.repository.ModuleRepository;
import com.sbi.mvs.repository.NetworkRepository;
import com.sbi.mvs.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LhoServiceImpl implements LhoService {

    @Autowired
    LhoRepository lhoRepository;

    @Autowired
    NetworkRepository networkRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    RegionRepository regionRepository;

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

    @Override
    public Pfhrms getPhrmsByType(String type, String id) {
        if("afgm".equals(type)){
            Optional<Network> networkDetails = networkRepository.findById(id);
            if(networkDetails.isPresent()){
                return networkDetails.get().getLhoPeopleData().getAgmatmPF();
            }
        } else {
            Optional<Region> regionDetails = regionRepository.findById(id);
            if(regionDetails.isPresent()) {
                if ("chMgr".equals(type)) {
                    return regionDetails.get().getRegionPeopleData().getChanelManager();
                } else if ("cmcsRbo".equals(type)) {
                    return regionDetails.get().getRegionPeopleData().getCmcsrrbo();
                }
            }
        }
        return null;
    }
}
