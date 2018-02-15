package com.krol.shajs.Service.Implementation;

import com.krol.shajs.Dto.BikeCarModelMapper;
import com.krol.shajs.Dto.VehicleDto;
import com.krol.shajs.Entity.Bike;
import com.krol.shajs.Entity.Car;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Enum.ExceptionCode;
import com.krol.shajs.Enum.VehicleType;
import com.krol.shajs.Exceptions.NotFoundException;
import com.krol.shajs.Repository.VehicleRepository;
import com.krol.shajs.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl extends BikeCarModelMapper implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<VehicleDto> showAll() {
        List<Vehicle> vehicleResultList = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtoResultList = new ArrayList<>();

        for (Vehicle vehicle : vehicleResultList) {
            if (vehicle.getVehicleType().equals("Bike")) {
                vehicleDtoResultList.add(bikeEntityToDto((Bike) vehicle));
            } else if (vehicle.getVehicleType().equals("Car")) {
                vehicleDtoResultList.add(carEntityToDto((Car) vehicle));
            }
        }
        return vehicleDtoResultList;
    }

    @Override
    public void deleteById(Long id) {
        vehicleRepository.delete(id);
        //TODO record with specified id doesnt exist
    }

    @Override
    public VehicleDto getVehicleDtoById(Long id) {
        Vehicle vehicle = getVehicleByID(id);

        switch (vehicle.getVehicleType()) {
            case "Bike":
                return bikeEntityToDto((Bike) vehicle);
            case "Car":
                return carEntityToDto((Car) vehicle);
        } //Todo handle id not found
        return null;
    }

    public Vehicle getVehicleByID(Long id)
    {
        return vehicleRepository.findOne(id); //TODO record with specified id doesnt exist
    }

/*    @Override
    public VehicleDto findVehicle(Long id) throws NotFoundException {
        Optional<Car> carOptional = carRepository.findById(id);

        if(carOptional.isPresent()) return carOptional.get();
        else throw new NotFoundException(ExceptionCode.VEHICLE_NOT_FOUND);

    }*/
}
