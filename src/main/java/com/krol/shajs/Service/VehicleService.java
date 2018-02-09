package com.krol.shajs.Service;


import com.krol.shajs.Entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VehicleService {

    public List<Vehicle> addCar();
    public List<Vehicle> showAll();
}
