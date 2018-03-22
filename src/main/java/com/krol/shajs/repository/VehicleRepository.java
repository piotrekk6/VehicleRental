package com.krol.shajs.repository;

import com.krol.shajs.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Set<Vehicle> findAllByOrderById();

}
