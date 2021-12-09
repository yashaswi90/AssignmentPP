package com.cab.management.CabAvailableManagement.controller;


import com.cab.management.CabAvailableManagement.entity.CabState;
import com.cab.management.CabAvailableManagement.entity.Location;
import com.cab.management.CabAvailableManagement.services.CabAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CabAvaialbleController {
    @Autowired
    private CabAvailableService cabAvailableService;

    @GetMapping("/getAvailableCab")
    public List<CabState> getAvailableCabByLocation(@RequestBody Location location){
        return cabAvailableService.getAvaialbleCabByLocation(location);
    }
}
