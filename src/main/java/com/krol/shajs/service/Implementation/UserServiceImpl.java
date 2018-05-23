package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.security.AddRoleDto;
import com.krol.shajs.dto.security.UserDto;
import com.krol.shajs.entity.Role;
import com.krol.shajs.entity.User;
import com.krol.shajs.exceptions.VehicleRentApplicationException;
import com.krol.shajs.repository.RoleRepository;
import com.krol.shajs.repository.UserRepository;
import com.krol.shajs.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.krol.shajs.enums_converters.ExceptionCode.USER_ALREADY_EXISTS;
import static com.krol.shajs.enums_converters.ExceptionCode.USER_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bcryptEncoder;
    private final RoleRepository roleRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    public User getUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    private List<SimpleGrantedAuthority> getAuthority(User user) {

        return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole().name())).collect(Collectors.toList());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) throws VehicleRentApplicationException {
        return userRepository.findById(id).orElseThrow(() -> new VehicleRentApplicationException(USER_NOT_FOUND));
    }

    @Override
    public UserDto save(UserDto userDto) throws VehicleRentApplicationException {
        if(userRepository.existsByUsername(userDto.getUsername())) throw new VehicleRentApplicationException(USER_ALREADY_EXISTS);
        User user = new User();
        user.setUsername(userDto.getUsername().trim());
        user.setPassword(bcryptEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return userDto;
    }

    @Override
    public void addRoles(AddRoleDto roleDto) throws VehicleRentApplicationException {
        User user = getUserByUsername(roleDto.getUserName());
        Optional.ofNullable(user).orElseThrow(() -> new VehicleRentApplicationException(USER_NOT_FOUND));
        Set<Role> roles = roleDto.getRoles()
                                 .stream()
                                 .map(role -> Optional.ofNullable(roleRepository.findByRole(role))
                                                      .orElseGet(() -> roleRepository.save(new Role(role))))
                                 .collect(Collectors.toSet());
        user.addRoles(roles);
        userRepository.save(user);
    }

}
