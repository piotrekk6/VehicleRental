package com.krol.shajs.dto;

import com.krol.shajs.enums_converters.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditCarDto  extends  VehicleDto{
    private Long id;
    private String model;
    private Color color;

}
