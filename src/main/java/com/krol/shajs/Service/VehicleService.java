package com.krol.shajs.Service;


import com.krol.shajs.Dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    List<VehicleDto> showAll();
    void deleteById(Long id);
    VehicleDto showOne(Long id);

}
