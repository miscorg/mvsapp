package com.sbi.mvs.service;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.entity.FieldValues;
import com.sbi.mvs.repository.AtmRepository;
import com.sbi.mvs.repository.BranchRepository;
import com.sbi.mvs.repository.ValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AtmServiceImpl implements AtmService{

    @Autowired
    AtmRepository atmRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    ValuesRepository valuesRepository;

    @Override
    public List<String> getFieldValueByName(String field) {

        Map<String, List<String>> fieldMap = new HashMap<>();
        fieldMap.put("site", Arrays.asList("Onsite", "Offsite"));
        fieldMap.put("ownershipType", Arrays.asList("Capex", "Opex-TOM", "Opex-MOF"));
        fieldMap.put("networkType", Arrays.asList("SBI-CONNECT", "VSAT-HCL", "VSAT-HUGHES", "VSAT-AIRTEL"));
        fieldMap.put("oemMake",  Arrays.asList("DieBold", "Hitachi", "NCR", "Hyosung"));
        fieldMap.put("model",  Arrays.asList("NCR22E", "NCR22"));
        fieldMap.put("msVender", Arrays.asList("FSS", "Hitachi", "NCR", "CMS"));
        fieldMap.put("cashRepType", Arrays.asList("Branch", "CMS", "NCR", "Hitachi"));
        fieldMap.put("phases", Arrays.asList("Phase X", "Phase XI", "Phase XII", "Phase XIII", "Prior to Phase X"));

        List<FieldValues> fieldValueList = valuesRepository.findByKey(field);
        List<String> values = fieldValueList.stream().map(FieldValues::getValue).collect(Collectors.toList());
        return values;
    }

    @Override
    public List<FieldValues> getFieldValueCombination(String field) {
        return valuesRepository.findByKey(field);
    }

    @Override
    public List<FieldValues> getFieldValueCombination(String field, Long parent) {
        return valuesRepository.findByKeyAndParentId(field, parent);
    }

    @Override
    public List<ATM> fetchAtmList(String branchId, String branchType)
    {
        System.out.println(branchId);
        System.out.println(branchType);

        if(branchType.equals("cashLink"))
        {
            Branch branch = this.branchRepository.findById(branchId).orElse(null);
            return this.atmRepository.findAllByCashLinkBranch(branch);
        }
        else
        {
            Branch branch = this.branchRepository.findById(branchId).orElse(null);
            return this.atmRepository.findAllByOwnerBranch(branch);
        }
    }

    @Override
    public ATM getAtmById(String atmId) {
        return atmRepository.findById(atmId).get();
    }

    @Override
    public ATM updateAtmById(String atmId, ATM atm) {
        atm.setAtmId(atmId);
        return atmRepository.save(atm);
    }
}
