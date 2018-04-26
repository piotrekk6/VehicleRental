package com.krol.shajs.dto.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private int age;
    private int salary;
}
