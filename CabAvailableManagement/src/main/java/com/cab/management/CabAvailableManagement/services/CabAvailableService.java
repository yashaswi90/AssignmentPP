package com.cab.management.CabAvailableManagement.services;

import com.cab.management.CabAvailableManagement.entity.CabState;
import com.cab.management.CabAvailableManagement.entity.Location;
import com.cab.management.CabAvailableManagement.repository.CabAvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabAvailableService {

    @Autowired
    private CabAvailableRepository cabAvailableRepository;

    public List<CabState> getAvaialbleCabByLocation(Location location) {

        List<CabState> cabs = cabAvailableRepository.findAllByLocation(location);
        return cabs;
    }

    public void saveIdleCab(CabState cabState) {
        cabAvailableRepository.save(cabState);
    }


    public void removeCab(String id) {
        cabAvailableRepository.deleteById(id);
    }

    public CabState fetchCab(String cab_number) {
        CabState cabState = cabAvailableRepository.findByCabNumber(cab_number);
        return cabState;
    }
}
