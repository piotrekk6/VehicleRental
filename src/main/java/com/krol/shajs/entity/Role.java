package com.krol.shajs.entity;

import com.krol.shajs.enums_converters.RoleTypes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private RoleTypes role;
}
