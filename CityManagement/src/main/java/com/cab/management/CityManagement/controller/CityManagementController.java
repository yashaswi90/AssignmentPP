package com.cab.management.CityManagement.controller;

import com.cab.management.CityManagement.domain.City;
import com.cab.management.CityManagement.services.CityManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityManagementController {

    @Autowired
    private CityManagementService cityManagementService;

    @PostMapping("/onboard/city")
    public void onboardingCity(@RequestBody City city) {
        cityManagementService.registerCityService(city);
    }
}
