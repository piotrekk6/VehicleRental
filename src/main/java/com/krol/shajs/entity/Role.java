package com.krol.shajs.entity;

import com.krol.shajs.enums_converters.RoleTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private RoleTypes role;

    public Role(RoleTypes role) {
        this.role = role;
    }
}
