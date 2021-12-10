package com.cab.management.CabAvailableManagement.repository;

import com.cab.management.CabAvailableManagement.entity.CabState;
import com.cab.management.CabAvailableManagement.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CabAvailableRepository extends JpaRepository<CabState, String> {


    List<CabState> findAllByLocation(Location location);

    @Transactional
    @Modifying
    @Query("DELETE FROM CabState u WHERE u.cab_number = :cabNumber")
    void deleteByCabNumber(@Param("cabNumber") String cabNumber);

    @Query("SELECT u FROM CabState u WHERE u.cab_number = :cabNumber")
    CabState findByCabNumber(String cabNumber);
}
