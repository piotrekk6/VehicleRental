package com.krol.shajs.dto;

import com.krol.shajs.enums_converters.Color;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class VehicleBorrowDto {

    private Long id;


    private String model;
    private Color color;
    private LocalDate productionDate;

    private LocalDate borrowDate;
    private String borrowerName;
}
