package com.sbi.mvs.repository;

import com.sbi.mvs.entity.Module;
import com.sbi.mvs.entity.Network;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, String> {
}
