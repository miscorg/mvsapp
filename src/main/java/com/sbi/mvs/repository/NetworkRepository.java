package com.sbi.mvs.repository;

import com.sbi.mvs.entity.LHO;
import com.sbi.mvs.entity.Network;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NetworkRepository extends JpaRepository<Network, String> {
}
