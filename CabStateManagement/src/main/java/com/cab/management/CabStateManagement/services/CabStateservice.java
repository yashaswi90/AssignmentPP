package com.cab.management.CabStateManagement.services;

import com.cab.management.CabStateManagement.entity.Cab;
import com.cab.management.CabStateManagement.entity.CabState;
import com.cab.management.CabStateManagement.enums.State;
import com.cab.management.CabStateManagement.repository.CabStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabStateservice {

    @Autowired
    private CabStateRepository cabStateRepository;

    public void saveCabState(Cab cab) {
        CabState cabState = CabState.builder().cabId(cab.getCab_number()).state(State.IDLE).build();
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
