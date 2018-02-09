package com.krol.shajs.Entity;

import com.krol.shajs.Enum.Color;
import com.krol.shajs.Enum.DateConverter;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
public class Car extends Vehicle {

    private String brand;
    private Color color;

    @Convert(converter = DateConverter.class)
    private LocalDate productionDate;

}
