package com.krol.shajs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class BorrowDto {
    @NotNull
    @Pattern(regexp = "[0-9]+")
    private Long vehicleId;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    private Long borrowerId;
    private LocalDate date;
}
