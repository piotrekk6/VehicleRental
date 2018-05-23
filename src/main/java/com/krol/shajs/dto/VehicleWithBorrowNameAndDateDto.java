package com.krol.shajs.dto;

import com.krol.shajs.enums_converters.Color;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class VehicleWithBorrowNameAndDateDto {

    private Long id;

    private String vehicleType;
    private String model;
    private String manufacturerName;
    private String name;
    private Color color;
    private LocalDate productionDate;

    private LocalDate borrowDate;
    private String borrowerFirstName;
    private String borrowerSecondName;
}
