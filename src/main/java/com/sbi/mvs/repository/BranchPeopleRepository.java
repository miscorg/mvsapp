package com.sbi.mvs.repository;

import com.sbi.mvs.entity.Branch;
import com.sbi.mvs.entity.BranchPeopleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchPeopleRepository extends JpaRepository<BranchPeopleData,Long> {
}
