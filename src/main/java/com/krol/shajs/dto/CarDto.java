package com.krol.shajs.dto;

import com.krol.shajs.enums_converters.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CarDto extends VehicleDto {

    private String model;
    private Color color;
    private LocalDate productionDate;

}
