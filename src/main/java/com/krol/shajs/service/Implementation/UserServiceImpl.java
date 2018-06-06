package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.security.AddRoleDto;
import com.krol.shajs.dto.security.UserDto;
import com.krol.shajs.entity.Role;
import com.krol.shajs.entity.User;
import com.krol.shajs.enums_converters.ExceptionCode;
import com.krol.shajs.exceptions.NotFoundException;
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
        userRepository.delete(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(UserDto userDto) throws NotFoundException {
        if(userRepository.existsByUsername(userDto.getUsername()))
        {
            throw new NotFoundException(ExceptionCode.VEHICLE_ALREADY_BORROWED);
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(bcryptEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void addRoles(AddRoleDto roleDto) {
        User user = getUserByUsername(roleDto.getUserName());
        Set<Role> roles = roleDto.getRoles().stream()
                                 .map(role -> Optional.ofNullable(roleRepository.findByRole(role))
                                                      .orElseGet(() -> roleRepository.save(new Role(role))))
                                 .collect(Collectors.toSet());
        user.addRoles(roles);
        userRepository.save(user);
    }

}
