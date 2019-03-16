package com.sbi.mvs.service;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    AtmRepository atmRepository;

    @Override
    public Set<Branch> getCashLinkBranch() {
        List<ATM> atmList = atmRepository.findAll();
        Set<Branch> cashLinkBranch = atmList.stream().map(ATM::getCashLinkBranch).collect(Collectors.toSet());
        return cashLinkBranch;
    }

    @Override
    public Set<Branch> getOwnerBranch() {
        List<ATM> atmList = atmRepository.findAll();
        Set<Branch> ownerBranch = atmList.stream().map(ATM::getOwnerBranch).map(t -> {
            t.setBranchType(null);
            t.setRegion(null);
            t.setBranchPeopleData(null);
            return t;
        }).collect(Collectors.toSet());
        return ownerBranch;
    }
}
