package com.krol.shajs.service;


import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.exceptions.ApplicationException;

import java.util.List;

public interface VehicleService {

    List<VehicleDto> getAllVehiclesOrderById();
    void deleteById(Long id) throws ApplicationException;
    VehicleDto getVehicleById(Long id) throws ApplicationException;
    Vehicle getVehicleByID(Long id) throws ApplicationException;
    List<Vehicle> getAll();

}
