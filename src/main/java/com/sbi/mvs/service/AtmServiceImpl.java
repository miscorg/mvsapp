package com.sbi.mvs.service;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.repository.AtmRepository;
import com.sbi.mvs.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AtmServiceImpl implements AtmService{

    @Autowired
    AtmRepository atmRepository;

    @Autowired
    BranchRepository branchRepository;

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
        return fieldMap.get(field);
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
    public void save(ATM atmData) {
        this.atmRepository.save(atmData);
    }
}
