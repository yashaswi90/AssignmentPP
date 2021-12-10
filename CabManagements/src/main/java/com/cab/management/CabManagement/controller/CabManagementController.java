package com.cab.management.CabManagement.controller;

import com.cab.management.CabManagement.domain.Cab;
import com.cab.management.CabManagement.entity.CabEntity;
import com.cab.management.CabManagement.entity.Location;
import com.cab.management.CabManagement.services.CabRegistrationPublisher;
import com.cab.management.CabManagement.services.RegisterCabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableBinding(CabRegistrationPublisher.class)
public class CabManagementController {

    @Autowired
    CabRegistrationPublisher cabRegistrationPublisher;

    @Autowired
    RegisterCabService registerCabService;

    @PostMapping("/onboardCab")
    public String registerCab(@RequestBody Cab cab) {
        CabEntity cabEntity = CabEntity.builder()
                .cabNumber(cab.getCab_number())
                .location(Location.builder().city(cab.getLocs().getCity())
                        .latitude(cab.getLocs().getLatitude())
                        .longitude(cab.getLocs().getLongitude())
                        .build())
                .build();

        registerCabService.onboardCab(cabEntity);
        cabRegistrationPublisher.cabRegistration().send(MessageBuilder.withPayload(cab).build());
        return "Onboarding Cab registered successfully";

    }

    @DeleteMapping("/deleteCab/{cabNumber}")
    public String deRegisterCab(@PathVariable String cabNumber) {
        Cab cab = registerCabService.findByCabNumber(cabNumber);
        registerCabService.deRegisterCab(cabNumber);
        cabRegistrationPublisher.cabDeRegistration().send(MessageBuilder.withPayload(cab).build());
        return "Cab de-registered successfully";

    }

    @GetMapping("/cab/{cabNumber}")
    public ResponseEntity<Cab> getByCabNumber(@PathVariable String cabNumber) {
        Cab cab = registerCabService.findByCabNumber(cabNumber);
        return ResponseEntity.ok(cab);
    }

    }
