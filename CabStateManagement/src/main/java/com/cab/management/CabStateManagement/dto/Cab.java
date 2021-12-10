package com.cab.management.CabStateManagement.dto;

import com.cab.management.CabStateManagement.entity.Location;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@ToString
public class Cab {
    private String id;
    private String cab_number;
    private Locs locs;

}
