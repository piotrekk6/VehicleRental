package com.krol.shajs.repository;

import com.krol.shajs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);
    List<User> findAll();
    boolean existsByUsername(String username);
}
