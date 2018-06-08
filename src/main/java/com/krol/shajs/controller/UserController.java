package com.krol.shajs.controller;

import com.krol.shajs.configuration.security.JwtTokenUtil;
import com.krol.shajs.dto.security.AddRoleDto;
import com.krol.shajs.dto.security.AuthToken;
import com.krol.shajs.dto.security.UserDto;
import com.krol.shajs.entity.User;
import com.krol.shajs.exceptions.VehicleRentApplicationException;
import com.krol.shajs.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @GetMapping
    public List<User> listUser() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getOne(@PathVariable(value = "id") long id) throws VehicleRentApplicationException {
        return userService.findById(id);
    }

    @PostMapping(value = "/roles")
    public void addRoles(@RequestBody @Valid AddRoleDto addRolesDto) throws VehicleRentApplicationException {
        userService.addRoles(addRolesDto);
    }
    @PostMapping(value = "/login/generate-token")
    public ResponseEntity<?> register(@Valid @RequestBody UserDto loginUser) throws AuthenticationException {
        loginUser.setUsername(loginUser.getUsername());
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.getUserByUsername(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @PostMapping(value = "/register")
    public UserDto saveUser(@RequestBody UserDto user) throws VehicleRentApplicationException {
        return userService.save(user);
    }
}