package com.krol.shajs.Service;

import com.krol.shajs.Entity.Bike;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> addCar() {
         vehicleRepository.save(new Bike());
         return null;
    }

    @Override
    public List<Vehicle> showAll() {
        return vehicleRepository.findAll();
    }

}
