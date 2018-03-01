package com.krol.shajs.enums_converters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VehicleType {
    CAR ("Car"),
    BIKE ("Bike");

    private String vehicleType;

}
