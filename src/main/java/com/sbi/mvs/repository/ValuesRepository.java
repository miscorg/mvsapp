package com.sbi.mvs.repository;

import com.sbi.mvs.entity.Values;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValuesRepository extends JpaRepository<Values, Long> {

    List<Values> findByKey(String key);
    List<Values> findByKeyAndParentId(String key, Long parentId);

}
