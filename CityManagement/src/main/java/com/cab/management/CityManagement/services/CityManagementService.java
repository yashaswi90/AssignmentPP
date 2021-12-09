package com.cab.management.CityManagement.services;

import com.cab.management.CityManagement.domain.City;
import com.cab.management.CityManagement.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManagementService {

    @Autowired
    private CityRepository cityRepository;

    public void registerCityService(City city) {
        cityRepository.save(city);
    }
}
