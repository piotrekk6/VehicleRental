package com.krol.shajs.dto;

import com.krol.shajs.enums_converters.Color;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto extends VehicleDto {

    private String model;
    private Color color;
    private LocalDate productionDate;
    private String manufacturerName;

}
