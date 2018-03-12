package com.krol.shajs.dto;

import com.krol.shajs.enums_converters.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BorrowedVehicleDto {

    String vehicleType;
    String vehicleName;
    String model;
    Color color;
    LocalDate productionDate;

    String borrowerName;

    LocalDate borrowDate;
}
