package com.krol.shajs.service;


import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.exceptions.NotFoundException;

import java.util.List;

public interface VehicleService {

    List<VehicleDto> getAllVehiclesOrderById();
    void deleteById(Long id) throws NotFoundException;
    VehicleDto getVehicleById(Long id) throws NotFoundException;
    Vehicle getVehicleByID(Long id) throws NotFoundException;
    List<Vehicle> getAll();

}
