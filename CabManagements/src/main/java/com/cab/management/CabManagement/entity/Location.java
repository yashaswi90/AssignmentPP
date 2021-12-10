package com.cab.management.CabManagement.entity;

import com.cab.management.CabManagement.domain.Cab;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Builder
@Data
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "location_id", updatable = false, nullable = false)
    private String id;

    private String city;
    private Long latitude;
    private Long longitude;

    @OneToOne(mappedBy = "location")
    private CabEntity cabEntity;

}

