package com.cab.management.CabAvailableManagement.services;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CabAvailableBinding {

    String ON_TRIP_CAB="onTripCab";

    @Input(ON_TRIP_CAB)
    SubscribableChannel onTripCab();

    String AVAILABLE_CAB = "availableCab";

    @Input(AVAILABLE_CAB)
    SubscribableChannel availableCab();

}
