package com.krol.shajs.service;

import com.krol.shajs.dto.security.AddRoleDto;
import com.krol.shajs.dto.security.UserDto;
import com.krol.shajs.entity.User;
import com.krol.shajs.exceptions.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findById(Long id);
    public User getUserByUsername(String userName);
    UserDetails loadUserByUsername(String userName);
    void addRoles(AddRoleDto roleDto) throws NotFoundException;
}
