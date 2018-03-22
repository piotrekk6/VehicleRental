package com.krol.shajs.entity;

import com.krol.shajs.enums_converters.Color;
import com.krol.shajs.enums_converters.ColorConverter;
import com.krol.shajs.enums_converters.DateConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car extends Vehicle {

    private String model;

    private Color color;

    @Convert(converter = DateConverter.class)
    private LocalDate productionDate;

}
