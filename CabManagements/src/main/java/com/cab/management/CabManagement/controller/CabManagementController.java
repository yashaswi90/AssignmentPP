package com.cab.management.CabManagement.controller;

import com.cab.management.CabManagement.domain.Cab;
import com.cab.management.CabManagement.domain.Locs;
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
        CabEntity cabEntity = registerCabService.findByCabNumber(cabNumber);
        Cab cab = Cab.builder().cab_number(cabEntity.getCabNumber())
                .locs(Locs.builder()
                        .city(cabEntity.getLocation()
                                .getCity()).latitude(cabEntity.getLocation().getLatitude())
                        .longitude(cabEntity.getLocation().getLatitude()).id(cabEntity.getLocation().getId()).build())
                .id(cabEntity.getId()).build();
        registerCabService.deRegisterCab(cabEntity.getId());
        cabRegistrationPublisher.cabDeRegistration().send(MessageBuilder.withPayload(cab).build());
        return "Cab de-registered successfully";

    }

    @GetMapping("/cab/{cabNumber}")
    public ResponseEntity<Cab> getByCabNumber(@PathVariable String cabNumber) {
        CabEntity cabEntity = registerCabService.findByCabNumber(cabNumber);
        Cab cab = Cab.builder().cab_number(cabEntity.getCabNumber())
                .locs(Locs.builder()
                        .city(cabEntity.getLocation()
                                .getCity()).latitude(cabEntity.getLocation().getLatitude())
                        .longitude(cabEntity.getLocation().getLatitude()).id(cabEntity.getLocation().getId()).build())
                .id(cabEntity.getId()).build();
        return ResponseEntity.ok(cab);
    }

    }
