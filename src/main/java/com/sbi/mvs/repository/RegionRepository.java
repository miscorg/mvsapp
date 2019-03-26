package com.sbi.mvs.repository;

import com.sbi.mvs.entity.Module;
import com.sbi.mvs.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,String> {

    List<Region> findByModule(Module module);
}
