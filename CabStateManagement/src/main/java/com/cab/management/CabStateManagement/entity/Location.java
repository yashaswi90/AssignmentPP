package com.cab.management.CabStateManagement.entity;/*
package com.cab.management.CabStateManagement.entity;

import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
public class Location {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "location_id", updatable = false, nullable = false)
    private String id;

    private Long latitude;
    private Long longitude;

    @OneToOne(mappedBy = "location")
    private CabState cabState;

}
*/
