package com.sbi.mvs.repository;

import com.sbi.mvs.entity.Pfhrms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PfhrmsRepository extends JpaRepository<Pfhrms,String> {

    List<Pfhrms> findAllByPfIdStartingWith(String userId);
}
