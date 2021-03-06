package com.krol.shajs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class VehicleDto {
    private Long id;

    @JsonProperty(access =  JsonProperty.Access.READ_ONLY)
    private String vehicleType;
}
