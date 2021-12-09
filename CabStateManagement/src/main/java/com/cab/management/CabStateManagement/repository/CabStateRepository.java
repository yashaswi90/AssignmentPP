package com.cab.management.CabStateManagement.repository;

import com.cab.management.CabStateManagement.entity.CabState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabStateRepository extends CrudRepository<CabState, String> {
}
