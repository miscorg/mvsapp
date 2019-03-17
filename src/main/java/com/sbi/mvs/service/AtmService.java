package com.sbi.mvs.service;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Values;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AtmService {

    List<String> getFieldValueByName(String field);
    List<Values> getFieldValueCombination(String field);
    List<Values> getFieldValueCombination(String field, Long parent);
    List<ATM> fetchAtmList(String branchId, String branchType);
    ATM getAtmById(String atmId);
    ATM updateAtmById(String atmId, ATM atm);
}
