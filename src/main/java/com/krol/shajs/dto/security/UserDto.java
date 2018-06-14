package com.krol.shajs.dto.security;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UserDto {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 4)
    private String password;
}
