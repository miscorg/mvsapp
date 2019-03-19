package com.sbi.mvs.controller;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("atm")
public class AtmController {

    @Autowired
    AtmService atmService;

    @GetMapping("/field/{fieldName}")
    public ResponseEntity<?> getAllAtmFieldValuesById(@PathVariable String fieldName){
        return new ResponseEntity<>(atmService.getFieldValueByName(fieldName), HttpStatus.OK);
    }

    @GetMapping("/field/{fieldName}/{parent}")
    public ResponseEntity<?> getAllAtmFieldValuesById(@PathVariable String fieldName, @PathVariable Long parent){
        return new ResponseEntity<>(atmService.getFieldValueCombination(fieldName,parent), HttpStatus.OK);
    }

    @GetMapping("/fieldVals")
    public ResponseEntity<?> getAllAtmFieldValues()
    {
        return new ResponseEntity<>(atmService.fetchFieldValues(), HttpStatus.OK);
    }

    @PutMapping("{atmId}")
    private ResponseEntity<?> updateAtmInfo(@PathVariable String atmId, @RequestBody ATM atm){
        return new ResponseEntity<>(atmService.updateAtmById(atmId, atm),HttpStatus.OK);
    }


    @GetMapping("/atmList/{branchType}/{branchId}")
    public ResponseEntity<List<ATM>> fetchAtmList(@PathVariable String branchType,
                                                  @PathVariable String branchId)
    {
        List<ATM> atmList = this.atmService.fetchAtmList(branchId, branchType);
        return ResponseEntity.ok(atmList);
    }

    @GetMapping("/{atmId}")
    public ResponseEntity<?> getAtmDetailsById(@PathVariable String atmId){
        ATM atm = atmService.getAtmById(atmId);
        return new ResponseEntity<>(atm, HttpStatus.OK);
    }

    @GetMapping("{atmId}/auxinfo")
    public ResponseEntity<?> getAtmAuxInfo(@PathVariable String atmId){
        return new ResponseEntity<>(atmService.getAtmById(atmId).getAtmAuxInfo(), HttpStatus.OK);
    }

    @GetMapping("{atmId}/networkinfo")
    public ResponseEntity<?> getAtmNetworkInfo(@PathVariable String atmId){
        return new ResponseEntity<>(atmService.getAtmById(atmId).getAtmNetwork(), HttpStatus.OK);
    }



}
