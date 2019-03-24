package com.sbi.mvs.service;

import com.sbi.mvs.dto.DashboardDTO;
import com.sbi.mvs.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService{

    @Autowired
    AtmRepository atmRepository;

    @Override
    public List<DashboardDTO> getDashboardInfo() {

        List<DashboardDTO> response = new ArrayList<>();
        List lhoCount = atmRepository.getLhoCount();
        lhoCount.forEach(t -> {
            Object[] obj = (Object[]) t;
            BigDecimal totalAtm = (BigDecimal)obj[0];
            BigDecimal verifiedAtm = (BigDecimal)obj[1];
            long unverifiedAtm = totalAtm.longValue() - verifiedAtm.longValue();
            response.add(new DashboardDTO(obj[2].toString(),totalAtm.longValue(),verifiedAtm.longValue(),unverifiedAtm));
        });
        return response;
    }
}
