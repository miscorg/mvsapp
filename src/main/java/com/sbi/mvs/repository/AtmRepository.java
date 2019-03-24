package com.sbi.mvs.repository;

import com.sbi.mvs.dto.DashboardDTO;
import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends JpaRepository<ATM,String> {

    List<ATM> findAllByOwnerBranch(Branch branch);

    List<ATM> findAllByCashLinkBranch(Branch branch);

    @Query(value = "SELECT count(atm.atm_id) AS totalATM, SUM(atm.status) as confirmedAtm, lho.lho_name " +
            "FROM ATM atm " +
            "LEFT JOIN  BRANCH branch ON atm.owner_branch = branch.branch_id " +
            "LEFT JOIN REGION region ON region.region_id = branch.region_id " +
            "LEFT JOIN MODULE module ON module.module_id = region.module_id " +
            "LEFT JOIN NETWORK network ON network.network_id =  module.network_id " +
            "LEFT JOIN LHO lho ON lho.lho_id = network.lho_id  GROUP BY lho.lho_id, lho.lho_name", nativeQuery = true)
    List getLhoCount();

}
