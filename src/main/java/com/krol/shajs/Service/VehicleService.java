package com.krol.shajs.Service;


import com.krol.shajs.Dto.VehicleDto;
import com.krol.shajs.Entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<VehicleDto> showAll();
    void deleteById(Long id);
    VehicleDto getVehicleDtoById(Long id);
    Vehicle getVehicleByID(Long id);

}
