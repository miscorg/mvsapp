package com.sbi.mvs.service;

import com.sbi.mvs.dto.LhoUserDto;
import com.sbi.mvs.entity.*;
import com.sbi.mvs.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Autowired
    PfhrmsRepository pfhrmsRepository;

    @Autowired
    LhoPeopleDataRepository lhoPeopleDataRepository;

    @Autowired
    RegionPeopleDataRepository regionPeopleDataRepository;

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

    @Override
    public void saveLhoUser(LhoUserDto lhoUser) {
        if(lhoUser.getNetworkId() != null){
            LHOPeopleData lhoPeopleData = new LHOPeopleData();
            lhoPeopleData.setNetworkId(lhoUser.getNetworkId());
            lhoPeopleData.setAgmatmPF(pfhrmsRepository.findById(lhoUser.getAgmatmPF()).get());
            lhoPeopleDataRepository.save(lhoPeopleData);
        }else if(lhoUser.getRegionId() != null){
            RegionPeopleData regionPeopleData = new RegionPeopleData();
            regionPeopleData.setRegionId(lhoUser.getRegionId());
            regionPeopleData.setChanelManager(pfhrmsRepository.findById(lhoUser.getChanelManager()).get());
            regionPeopleData.setCmcsrrbo(pfhrmsRepository.findById(lhoUser.getCmcsrrbo()).get());
            regionPeopleDataRepository.save(regionPeopleData);
        }
    }
}
