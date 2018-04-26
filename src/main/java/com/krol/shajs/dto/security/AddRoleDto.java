package com.krol.shajs.dto.security;

import com.krol.shajs.enums_converters.RoleTypes;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AddRoleDto {
    private String userName;
    private Set<RoleTypes> roles;
}
