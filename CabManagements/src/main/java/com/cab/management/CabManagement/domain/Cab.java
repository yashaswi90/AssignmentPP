package com.cab.management.CabManagement.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cab {


    private String id;

    private String cab_number;

    private Locs locs;


}
