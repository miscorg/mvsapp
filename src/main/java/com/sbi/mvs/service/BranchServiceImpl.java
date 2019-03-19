package com.sbi.mvs.service;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.entity.BranchPeopleData;
import com.sbi.mvs.entity.Pfhrms;
import com.sbi.mvs.repository.AtmRepository;
import com.sbi.mvs.repository.BranchPeopleRepository;
import com.sbi.mvs.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private AtmRepository atmRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchPeopleRepository branchPeopleRepository;

    @Override
    public Set<Branch> getCashLinkBranch(String searchKey) {
        List<ATM> atmList = atmRepository.findAll();
        Set<Branch> cashLinkBranch = atmList.stream().filter(t -> {
            if(searchKey == null) {
                return t.getCashLinkBranch() != null;
            }else {
                return t.getCashLinkBranch() != null && t.getCashLinkBranch().getBranchId().startsWith(searchKey);
            }
        }).map(ATM::getCashLinkBranch).collect(Collectors.toSet());
        return cashLinkBranch;
    }

    @Override
    public Set<Branch> getOwnerBranch(String searchKey) {
        List<ATM> atmList = atmRepository.findAll();
        Set<Branch> ownerBranch = atmList.stream()
                .filter(t -> {
                    if(searchKey == null) {
                        return t.getOwnerBranch() != null;
                    }else {
                        return t.getOwnerBranch() != null && t.getOwnerBranch().getBranchId().startsWith(searchKey);
                    }
                }).map(ATM::getOwnerBranch).collect(Collectors.toSet());
        return ownerBranch;
    }

    @Override
    public Pfhrms getBankUserDetails(String branchId, String role) {
        Optional<Branch> branch = branchRepository.findById(branchId);
        BranchPeopleData branchPeopleData = branch.get().getBranchPeopleData();
        if ("manager".equals(role)) {
            return branchPeopleData.getBranchManager();
        } else {
            return branchPeopleData.getAtmOfficer();
        }
    }
    public Branch fetchBranch(String branchId) {
        return this.branchRepository.findById(branchId).orElse(null);
    }
}
