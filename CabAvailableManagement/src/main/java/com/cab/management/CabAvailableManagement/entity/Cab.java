package com.cab.management.CabAvailableManagement.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Data
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String cab_number;
    private String city_id;


}
