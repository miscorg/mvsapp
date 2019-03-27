package com.sbi.mvs.repository;

import com.sbi.mvs.entity.LHOPeopleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LhoPeopleDataRepository extends JpaRepository<LHOPeopleData, String> {
}
