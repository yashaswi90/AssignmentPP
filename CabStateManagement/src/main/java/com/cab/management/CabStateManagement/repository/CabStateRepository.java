package com.cab.management.CabStateManagement.repository;

import com.cab.management.CabStateManagement.entity.CabState;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CabStateRepository extends CrudRepository<CabState, String> {

    @Query("SELECT u FROM CabState u WHERE u.cabId = :cabNumber")
    CabState findByCabNumber(String cabNumber);


    @Transactional
    @Modifying
    @Query("DELETE FROM CabState u WHERE u.cabId = :cabNumber")
    void deleteByCabNumber(@Param("cabNumber") String cabNumber);
}
