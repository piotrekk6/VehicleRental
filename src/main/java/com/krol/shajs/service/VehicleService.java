package com.krol.shajs.service;


import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.exceptions.VehicleRentApplicationException;

import java.util.List;

public interface VehicleService {

    List<VehicleDto> getAllVehiclesOrderById();
    void deleteById(Long id) throws VehicleRentApplicationException;
    VehicleDto getVehicleById(Long id) throws VehicleRentApplicationException;
    Vehicle getVehicleByID(Long id) throws VehicleRentApplicationException;
    List<Vehicle> getAll();

}
