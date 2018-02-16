package com.krol.shajs.Service;


import com.krol.shajs.Dto.VehicleDto;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Exceptions.NotFoundException;

import java.util.Collection;
import java.util.List;

public interface VehicleService {

    List<VehicleDto> showAll();
    void deleteById(Long id);
    VehicleDto getVehicleDtoById(Long id) throws NotFoundException;
    Vehicle getVehicleByID(Long id) throws NotFoundException;
    Collection<Vehicle> getAll();

}
