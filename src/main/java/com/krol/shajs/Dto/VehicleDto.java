package com.krol.shajs.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class VehicleDto {
    String manufacturer;
    String vehicleType;
}
