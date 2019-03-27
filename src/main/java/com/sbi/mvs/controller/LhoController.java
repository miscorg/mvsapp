package com.sbi.mvs.controller;

import com.sbi.mvs.dto.LhoUserDto;
import com.sbi.mvs.entity.LHOPeopleData;
import com.sbi.mvs.service.LhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LhoController {

    @Autowired
    LhoService lhoService;

    @GetMapping("lho")
    public ResponseEntity<?> getAllLho(){
        return new ResponseEntity<>(lhoService.getAllLho(),HttpStatus.OK);
    }

    @GetMapping("lho/{lhoId}/network")
    public ResponseEntity<?> getNetworkByLhoId(@PathVariable String lhoId){
        return new ResponseEntity<>(lhoService.getNetworkByLho(lhoId), HttpStatus.OK);
    }

    @GetMapping("network/{networkId}/module")
    public ResponseEntity<?> getModuleByNetworkId(@PathVariable String networkId){
        return new ResponseEntity<>(lhoService.getModuleByNetwork(networkId), HttpStatus.OK);
    }

    @GetMapping("module/{moduleId}/region")
    public ResponseEntity<?> getRegionModuleId(@PathVariable String moduleId){
        return new ResponseEntity<>(lhoService.getRegionByModule(moduleId), HttpStatus.OK);
    }

    @GetMapping("lho/{type}/{id}")
    public ResponseEntity<?> getUserDetailsByType(@PathVariable String type, @PathVariable String id){
        return new ResponseEntity<>(lhoService.getPhrmsByType(type,id), HttpStatus.OK);
    }

    @PostMapping("lho/user")
    public ResponseEntity<?> saveLhoPeopleData(@RequestBody LhoUserDto lhoUser){
        lhoService.saveLhoUser(lhoUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
