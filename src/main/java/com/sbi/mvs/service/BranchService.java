package com.sbi.mvs.service;

import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.entity.Pfhrms;

import java.util.Set;

public interface BranchService {

    Set<Branch> getCashLinkBranch();
    Set<Branch> getOwnerBranch();
    Pfhrms getBankUserDetails(String branchId, String role);

}
