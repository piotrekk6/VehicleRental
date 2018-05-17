package com.krol.shajs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@DiscriminatorValue(value = "dtype")
@EqualsAndHashCode
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dtype", insertable = false, updatable = false)
    String vehicleType;

    @Version
    private int version;

    @JsonIgnore
    public boolean isBike() {
        return this instanceof Bike;
    }
    @JsonIgnore
    public boolean isCar() {
        return this instanceof Car;
    }

}
