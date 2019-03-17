package com.sbi.mvs.controller;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveAtmData(ATM atmData)
    {
        try {
            this.atmService.save(atmData);
            HashMap<String, String> resMap = new HashMap<>();
            resMap.put("msg", "ATM Info Saved");
            return ResponseEntity.ok(resMap);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
