package com.krol.shajs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

import static com.krol.shajs.enums_converters.VehicleType.BIKE;
import static com.krol.shajs.enums_converters.VehicleType.CAR;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@DiscriminatorValue(value = "dtype")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dtype", insertable = false, updatable = false)
    String vehicleType;

    private String name;

    @JsonIgnore
    public boolean isBike() {
        return this.getVehicleType().equals(BIKE.getVehicleType());
    }
    @JsonIgnore
    public boolean isCar() {
        return this.getVehicleType().equals(CAR.getVehicleType());
    }

}
