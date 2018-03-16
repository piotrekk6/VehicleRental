package com.krol.shajs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class BorrowedVehicleDto {
    private Long id;
    private LocalDate date;

    private VehicleDto vehicleDto;
    private BorrowerDto borrowerDto;
}
