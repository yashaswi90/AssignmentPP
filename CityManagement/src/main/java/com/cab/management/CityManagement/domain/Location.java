package com.cab.management.CityManagement.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private Long id;

    private long latitude;
    private long longitude;

    @OneToOne(mappedBy = "location")
    private City city;
}
