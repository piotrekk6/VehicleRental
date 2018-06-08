package com.krol.shajs.dto.security;

import com.krol.shajs.enums_converters.RoleTypes;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class AddRoleDto {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 30, message = "{validation.msg.user.size}")
    @Pattern(regexp = "[^\\s-]")
    private String userName;

    @NotNull
    private Set<RoleTypes> roles;
}
