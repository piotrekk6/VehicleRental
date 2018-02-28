package com.krol.shajs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class VehicleIfBorrowed {

    Long vehicleId;
    String vehicleType;
    boolean isBorrowed;
    Long borrowerId;
    String borrowerName;
    String borrowerSecName;

}
