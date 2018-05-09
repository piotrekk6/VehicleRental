package com.krol.shajs.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BikeDto extends VehicleDto {
    private String name;
}
