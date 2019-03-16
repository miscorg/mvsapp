package com.sbi.mvs.service;

import com.sbi.mvs.entity.Branch;

import java.util.Set;

public interface BranchService {

    Set<Branch> getCashLinkBranch();
    Set<Branch> getOwnerBranch();
}
