package com.sbi.mvs.service;

import com.sbi.mvs.entity.ATM;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface AtmService {

    List<String> getFieldValueByName(String field);
    ATM getAtmById(String atmId);
}
