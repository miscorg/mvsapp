package com.sbi.mvs.repository;

import com.sbi.mvs.entity.FieldValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValuesRepository extends JpaRepository<FieldValues, Long> {

    List<FieldValues> findByKey(String key);
    List<FieldValues> findByKeyAndParentId(String key, Long parentId);

}
