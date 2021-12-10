package com.cab.management.CabManagement.domain;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@Data
public class Locs {

    private String id;
    private String city;
    private Long latitude;
    private Long longitude;


}

