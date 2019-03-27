package com.sbi.mvs.repository;

import com.sbi.mvs.entity.RegionPeopleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionPeopleDataRepository extends JpaRepository<RegionPeopleData, String> {
}
