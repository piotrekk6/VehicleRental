package com.krol.shajs.dto;

import com.krol.shajs.enums_converters.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto extends VehicleDto {

    private String model;
    private Color color;
    @DateTimeFormat(pattern = "yyy.MM.dd")
    private LocalDate productionDate;
    private String manufacturerName;

}
