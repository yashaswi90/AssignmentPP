package com.cab.management.CabStateManagement.controller;


import com.cab.management.CabStateManagement.entity.Cab;
import com.cab.management.CabStateManagement.entity.CabState;
import com.cab.management.CabStateManagement.services.CabStateservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CabStateController {

    @Autowired
    private CabStateservice cabStateservice;

    @PostMapping("/add")
    public void storeCabState(@RequestBody Cab cab) {

        cabStateservice.saveCabState(cab);
    }

}
