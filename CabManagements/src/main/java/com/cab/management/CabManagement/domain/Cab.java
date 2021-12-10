package com.cab.management.CabManagement.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Data
public class Cab {


    private String id;

    private String cab_number;
    private String city_id;


}
