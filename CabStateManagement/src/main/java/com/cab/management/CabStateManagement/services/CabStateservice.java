package com.cab.management.CabStateManagement.services;

import com.cab.management.CabStateManagement.dto.Cab;
import com.cab.management.CabStateManagement.entity.CabState;
import com.cab.management.CabStateManagement.entity.Location;
import com.cab.management.CabStateManagement.enums.State;
import com.cab.management.CabStateManagement.repository.CabStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabStateservice {

    @Autowired
    private CabStateRepository cabStateRepository;

    public void saveCabState(CabState cabState) {
        cabStateRepository.save(cabState);
    }

    public void removeCab(String id) {
        cabStateRepository.deleteById(id);
    }


    public void updateLocationCab(CabState cabState) {
        cabStateRepository.save(cabState);
    }

    public CabState fetchCab(String cab_number) {
        CabState cabState = cabStateRepository.findByCabNumber(cab_number);
        return cabState;
    }
}
