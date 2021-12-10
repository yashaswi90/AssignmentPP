package com.cab.management.CabAvailableManagement.services;

import com.cab.management.CabAvailableManagement.entity.Cab;
import com.cab.management.CabAvailableManagement.entity.CabState;
import com.cab.management.CabAvailableManagement.enums.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@EnableBinding({CabAvailableBinding.class})
public class CabAvailableListener {

    @Autowired
    private CabAvailableService cabStateservice;

    @StreamListener(target = CabAvailableBinding.AVAILABLE_CAB)
    public void registerAvailableCab(@Payload Cab cab) {
        if (Objects.nonNull(cab)) {
            CabState cabState = CabState.builder().cab_number(cab.getCab_number())
                    .state(State.IDLE).build();
            cabStateservice.saveIdleCab(cabState);
        }
    }


    @StreamListener(target = CabAvailableBinding.ON_TRIP_CAB)
    public void removeNonIdleCab(@Payload Cab cab) {
        if (Objects.nonNull(cab.getCab_number())) {
            CabState cabState = cabStateservice.fetchCab(cab.getCab_number());
            cabStateservice.removeCab(cabState.getId());
        }
    }

}
