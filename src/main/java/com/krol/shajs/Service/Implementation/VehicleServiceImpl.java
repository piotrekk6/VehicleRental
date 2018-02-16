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
import java.util.Collection;
import java.util.List;

@Service
public class VehicleServiceImpl extends BikeCarModelMapper implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> showAll() {
        List<Vehicle> vehicleResultList = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtoResultList = new ArrayList<>();

        for (Vehicle vehicle : vehicleResultList) {
            if (vehicle.getVehicleType().equals(VehicleType.CAR.getVehicleType())) {
                vehicleDtoResultList.add(bikeEntityToDto((Bike) vehicle));
            } else if (vehicle.getVehicleType().equals(VehicleType.BIKE.getVehicleType())) {
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
    public VehicleDto getVehicleDtoById(Long id) throws NotFoundException {
        Vehicle vehicle = getVehicleByID(id);

        switch (vehicle.getVehicleType()) {
            case "Bike":
                return bikeEntityToDto((Bike) vehicle);
            case "Car":
                return carEntityToDto((Car) vehicle);
        }
        return null;
    }

    public Vehicle getVehicleByID(Long id) throws NotFoundException {
        Vehicle vehicle = vehicleRepository.findOne(id);
        if (vehicle == null) throw new NotFoundException(ExceptionCode.VEHICLE_NOT_FOUND);
        else return vehicle;

    }

    @Override
    public Collection<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}
