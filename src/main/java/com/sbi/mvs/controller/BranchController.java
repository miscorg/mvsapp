package com.sbi.mvs.controller;

import com.sbi.mvs.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
