package com.cab.management.CabManagement.services;

import com.cab.management.CabManagement.domain.Cab;
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
        cabRepository.deleteByCabNumber(cabNumber);
    }

    public Cab findByCabNumber(String cabNumber) {
        CabEntity cabEntity = cabRepository.findByCabNumber(cabNumber);
        return Cab.builder().cab_number(cabEntity.getCabNumber()).id(cabEntity.getId()).build();
    }
}
