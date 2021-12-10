package com.cab.management.CabAvailableManagement.repository;

import com.cab.management.CabAvailableManagement.entity.CabState;
import com.cab.management.CabAvailableManagement.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabAvailableRepository extends JpaRepository<CabState, String> {


    List<CabState> findAllByLocation(Location location);

    void deleteByCabNumber(String cab_number);

}
