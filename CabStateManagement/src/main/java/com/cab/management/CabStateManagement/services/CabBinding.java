package com.cab.management.CabStateManagement.services;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CabBinding {
//    String GREETING = "greetingChannel";
    String INPUT="input";

    @Input(INPUT)
    SubscribableChannel input();

//    @Input(GREETING)
//    SubscribableChannel greeting();

    String DEREGISTER = "deRegisterCab";

    @Input(DEREGISTER)
    SubscribableChannel deRegisterCab();

}
