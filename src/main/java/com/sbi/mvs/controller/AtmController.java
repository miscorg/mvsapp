package com.sbi.mvs.controller;

import com.sbi.mvs.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{atmId}")
    public ResponseEntity<?> getAtmDetailsById(@PathVariable String atmId){
        return new ResponseEntity<>(atmService.getAtmById(atmId), HttpStatus.OK);
    }
}
