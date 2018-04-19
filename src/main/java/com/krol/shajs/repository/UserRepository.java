package com.krol.shajs.repository;

import com.krol.shajs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);
    List<User> findAll();
}
