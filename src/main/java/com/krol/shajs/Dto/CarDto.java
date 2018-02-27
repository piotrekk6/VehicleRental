package com.krol.shajs.Dto;

import com.krol.shajs.Enum.Color;
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
