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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bcryptEncoder;


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
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new VehicleRentApplicationException(USER_ALREADY_EXISTS);
        }
        User user = new User();
        user.setUsername(userDto.getUsername().trim());
        user.setPassword(bcryptEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return userDto;
    }
}
