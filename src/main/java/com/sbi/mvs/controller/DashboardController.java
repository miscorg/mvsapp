package com.sbi.mvs.controller;

import com.sbi.mvs.dto.DashboardDTO;
import com.sbi.mvs.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/dashboard")
    public ResponseEntity<List<DashboardDTO>> getDashBoardInfo(){
        return new ResponseEntity<>(dashboardService.getDashboardInfo(), HttpStatus.OK);
    }


}
