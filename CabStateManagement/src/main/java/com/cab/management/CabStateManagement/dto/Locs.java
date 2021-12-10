package com.cab.management.CabStateManagement.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Locs {

    private String city;
    private Long latitude;
    private Long longitude;


}

