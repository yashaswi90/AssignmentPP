package com.cab.management.CabManagement.services;

import com.cab.management.CabManagement.domain.Cab;
import com.cab.management.CabManagement.domain.Locs;
import com.cab.management.CabManagement.entity.CabEntity;
import com.cab.management.CabManagement.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCabService {

    @Autowired
    private CabRepository cabRepository;

    public void onboardCab(CabEntity cab) {
        cabRepository.save(cab);
    }

    public void deRegisterCab(String cabNumber) {
        cabRepository.delete(cabNumber);
    }

    public CabEntity findByCabNumber(String cabNumber) {
        return cabRepository.findByCabNumber(cabNumber);
        /*return Cab.builder().cab_number(cabEntity.getCabNumber())
                .locs(Locs.builder()
                        .city(cabEntity.getLocation()
                                .getCity()).latitude(cabEntity.getLocation().getLatitude())
                        .longitude(cabEntity.getLocation().getLatitude()).id(cabEntity.getLocation().getId()).build())
                .id(cabEntity.getId()).build();*/
    }
}
