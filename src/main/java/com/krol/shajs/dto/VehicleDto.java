package com.krol.shajs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class VehicleDto {
    Long id;

    @JsonProperty(access =  JsonProperty.Access.READ_ONLY)
    String vehicleType;
    String name;
}
