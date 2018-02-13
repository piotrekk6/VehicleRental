package com.krol.shajs.Entity;

import com.krol.shajs.Enum.Color;
import com.krol.shajs.Enum.ColorConverter;
import com.krol.shajs.Enum.DateConverter;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car extends Vehicle {

    private String model;

    @Convert(converter = ColorConverter.class)
    private Color color;

    @Convert(converter = DateConverter.class)
    private LocalDate productionDate;

}
