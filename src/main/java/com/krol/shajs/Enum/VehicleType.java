package com.krol.shajs.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VehicleType {
    CAR ("Car"),
    BIKE ("Bike");

    private String vehicleType;

}
