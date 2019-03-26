package com.sbi.mvs.repository;

import com.sbi.mvs.entity.LHO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LhoRepository  extends JpaRepository<LHO, String> {
}
