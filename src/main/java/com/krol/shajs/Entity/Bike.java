package com.krol.shajs.Entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Bike extends Vehicle {

    Integer weight;
}
