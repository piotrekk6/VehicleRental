package com.krol.shajs.controller;

import com.krol.shajs.dto.security.AddRoleDto;
import com.krol.shajs.dto.security.UserDto;
import com.krol.shajs.entity.User;
import com.krol.shajs.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users")
    public List<User> listUser() {
        return userService.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public User getOne(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/roles")
    public void addRoles(@RequestBody AddRoleDto addRolesDto)
    {
        userService.addRoles(addRolesDto);
    }
}
