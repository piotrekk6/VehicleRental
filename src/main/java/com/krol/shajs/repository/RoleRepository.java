package com.krol.shajs.repository;

import com.krol.shajs.entity.Role;
import com.krol.shajs.enums_converters.RoleTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRole(RoleTypes role);
}
