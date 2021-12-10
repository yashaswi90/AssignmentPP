package com.cab.management.CabManagement.services;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CabRegistrationPublisher {

    @Output("cabRegistrationChannel")
    MessageChannel cabRegistration();

    @Output("cabDeRegistrationChannel")
    MessageChannel cabDeRegistration();


}
