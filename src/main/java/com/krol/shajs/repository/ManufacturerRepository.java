package com.krol.shajs.repository;

import com.krol.shajs.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    boolean existsByName(String name);
    Manufacturer findByName(String name);
}
