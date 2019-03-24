package com.sbi.mvs.service;

import com.sbi.mvs.dto.DashboardDTO;
import com.sbi.mvs.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService{

    @Autowired
    AtmRepository atmRepository;

    @Override
    public List<DashboardDTO> getDashboardInfo() {


        return null;
    }
}
