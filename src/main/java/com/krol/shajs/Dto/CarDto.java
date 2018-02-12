package com.krol.shajs.Dto;

import com.krol.shajs.Enum.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarDto extends VehicleDto {

    private String brand;
    private Color color;

}
