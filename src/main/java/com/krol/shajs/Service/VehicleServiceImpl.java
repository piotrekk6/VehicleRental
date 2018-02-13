package com.krol.shajs.Service;

import com.krol.shajs.Dto.BikeCarModelMapper;
import com.krol.shajs.Dto.VehicleDto;
import com.krol.shajs.Entity.Bike;
import com.krol.shajs.Entity.Car;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VehicleServiceImpl extends BikeCarModelMapper implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<VehicleDto> showAll() {
        List<Vehicle> vehicleResultList = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtoResultList = new ArrayList<>();
        for (Vehicle vehicle : vehicleResultList) {
 /*            if(vehicle instanceof Bike)
            {
                vehicleDtoResultList.add(bikeEntityToDto((Bike)vehicle));
            }
            else if (vehicle instanceof Car)
            {
                vehicleDtoResultList.add(carEntityToDto((Car)vehicle));
            }*/
/*        for (Vehicle vehicle : vehicleResultList) {
            if(vehicle.getVehicleType().equals("Bike"))
            {
                vehicleDtoResultList.add(bikeEntityToDto((Bike)vehicle));
            }
            else if (vehicle.getVehicleType().equals("Car"))
            {
                vehicleDtoResultList.add(carEntityToDto((Car)vehicle));
            }
        }*/
            switch (vehicle.getVehicleType()) {
                case "Bike":
                    vehicleDtoResultList.add(bikeEntityToDto((Bike) vehicle));
                case "Car":
                    vehicleDtoResultList.add(carEntityToDto((Car) vehicle));
            }
        }
        return vehicleDtoResultList;
    }

    @Override
    public void deleteById(Long id) {
        vehicleRepository.delete(id);
    }

    @Override
    public VehicleDto showOne(Long id) {
        Vehicle vehicle = vehicleRepository.findOne(id);

        switch (vehicle.getVehicleType()) {
            case "Bike" : return bikeEntityToDto((Bike) vehicle);
            case "Car" : return carEntityToDto((Car) vehicle);
        }
        return null;
    }
}
