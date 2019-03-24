package com.sbi.mvs.repository;

import com.sbi.mvs.entity.Pincode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PincodeRepository extends JpaRepository<Pincode,String> {

    List<Pincode> findAllByPincodeStartingWith(String pincode);
}
