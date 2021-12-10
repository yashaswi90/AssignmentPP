package com.cab.management.CabManagement.repository;

import com.cab.management.CabManagement.entity.CabEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CabRepository extends JpaRepository<CabEntity, String> {
    @Transactional
    @Modifying
    @Query("DELETE FROM CabEntity u WHERE u.cabNumber = :cabNumber")
    void deleteByCabNumber(@Param("cabNumber") String cabNumber);

    @Query("SELECT u FROM CabEntity u WHERE u.cabNumber = :cabNumber")
    CabEntity findByCabNumber(@Param("cabNumber")String cabNumber);
}
