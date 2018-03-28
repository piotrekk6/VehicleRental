package com.krol.shajs.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor

@Getter
@Setter
@Embeddable
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturerName;

    public Manufacturer(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}

