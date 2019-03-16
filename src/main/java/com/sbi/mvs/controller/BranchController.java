package com.sbi.mvs.controller;

import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @GetMapping("/owner")
    public ResponseEntity<?> fetchOwnerBranchList(){
        return new ResponseEntity<>(branchService.getOwnerBranch(), HttpStatus.OK);
    }

    @GetMapping("/cashlink")
    public ResponseEntity<?> fetchCashLinkBranchList(){
        return new ResponseEntity<>(branchService.getCashLinkBranch(), HttpStatus.OK);
    }

    @GetMapping("{branchId}/{role}")
    public ResponseEntity<?> getBranchUserDetails(@PathVariable String branchId,@PathVariable String role) {
        return new ResponseEntity<>(branchService.getBankUserDetails(branchId, role), HttpStatus.OK);
    }

    @GetMapping("/branchObj/{branchId}")
    public ResponseEntity<?> fetchBranchData(@PathVariable String branchId){
        Branch branchIn = branchService.fetchBranch(branchId);
//        branchIn.setBranchPeopleData(branchService.fetchPeople(branchId));
//        branchIn.getBranchPeopleData().setBranch(null);
        return new ResponseEntity<>(branchIn, HttpStatus.OK);
    }
}
