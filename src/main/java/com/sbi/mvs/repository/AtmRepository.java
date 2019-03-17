package com.sbi.mvs.repository;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends JpaRepository<ATM,String> {

    List<ATM> findAllByOwnerBranch(Branch branch);

    List<ATM> findAllByCashLinkBranch(Branch branch);

}
