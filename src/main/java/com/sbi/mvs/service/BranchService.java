package com.sbi.mvs.service;

import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.entity.Pfhrms;

import java.util.Set;

public interface BranchService {

    Set<Branch> getCashLinkBranch(String searchKey);
    Set<Branch> getOwnerBranch(String searchKey);
    Pfhrms getBankUserDetails(String branchId, String role);
    Branch fetchBranch(String branchId);

}
