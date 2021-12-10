package com.cab.management.CabStateManagement.services;

import com.cab.management.CabStateManagement.entity.Cab;
import com.cab.management.CabStateManagement.entity.CabState;
import com.cab.management.CabStateManagement.enums.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@EnableBinding({CabBinding.class})
public class CabStateManagementListener {

    @Autowired
    private CabStateservice cabStateservice;

    @StreamListener(target = CabBinding.INPUT)
    public void registerCabListener(Cab cab) {
        if (Objects.nonNull(cab)) {
            CabState cabState = CabState.builder().cabId(cab.getCab_number())
                    .state(State.IDLE).build();
            cabStateservice.saveCabState(cab);
        }
    }

    @StreamListener(target = CabBinding.DEREGISTER)
    public void deRegisterCabListener(@Payload Cab cab) {
        if (Objects.nonNull(cab)) {
            CabState cabState = cabStateservice.fetchCab(cab.getCab_number());
            cabStateservice.removeCab(cabState.getId());
        }
    }

   /* @StreamListener(value = CabLocationChange.INPUT)
    public void locationChangeCabListener(@Payload Cab cab) {
        if (Objects.nonNull(cab)) {
            CabState cabState = CabState.builder().cabId(cab.getCab_number())
                    .state(State.IDLE).build();
            cabStateservice.updateLocationCab(cabState);
        }
    }*/
}
