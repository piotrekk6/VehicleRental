package com.krol.shajs.Repository;

import com.krol.shajs.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
