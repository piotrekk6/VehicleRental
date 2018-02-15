package com.krol.shajs.Dto;

import com.krol.shajs.Enum.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EditCarDto  extends  VehicleDto{
    private Long id;
    private String model;
    private Color color;

}
