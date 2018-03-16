package com.krol.shajs.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class BorrowDto {
    private Long vehicleId;
    private Long borrowerId;
    private LocalDate date;
}
