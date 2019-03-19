package com.sbi.mvs.service;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.FieldValues;

import java.util.List;

public interface AtmService {

    List<String> getFieldValueByName(String field);
    List<FieldValues> getFieldValueCombination(String field);
    List<FieldValues> getFieldValueCombination(String field, Long parent);
    List<FieldValues> fetchFieldValues();
    List<ATM> fetchAtmList(String branchId, String branchType);
    ATM getAtmById(String atmId);
    ATM updateAtmById(String atmId, ATM atm);
}
