package com.krol.shajs.enums_converters.dtoConverter;

import com.krol.shajs.dto.BikeDto;
import com.krol.shajs.dto.CarDto;
import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.entity.Bike;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleEntityDtoConverter {

    public VehicleDto createDto(Vehicle vehicle)
    {
        if (vehicle.isBike()) {
            Bike bike = (Bike) vehicle;
            BikeDto bikeDto = new BikeDto();
            bikeDto.setId(bike.getId());
            bikeDto.setName(bike.getName());
            bikeDto.setVehicleType(bike.getVehicleType());
            return bikeDto;
        } else if (vehicle.isCar()) {
            Car car = (Car) vehicle;
            CarDto carDto = new CarDto();
            carDto.setId(vehicle.getId());
            carDto.setColor(car.getColor());
            carDto.setModel(car.getModel());
            carDto.setProductionDate(car.getProductionDate());
            carDto.setVehicleType(car.getVehicleType());
            carDto.setManufacturerName(car.getManufacturer().getManufacturerName());
            return carDto;
        }
        return null;
    }

    public Car createEntity(CarDto carDto)
    {
        Car car = new Car();
        car.setId(carDto.getId());
        car.setProductionDate(carDto.getProductionDate());
        car.setModel(carDto.getModel());
        car.setColor(carDto.getColor());
        return car;
    }

    public Bike createEntity(BikeDto bikeDto){
        Bike bike = new Bike();
        bike.setName(bike.getName());
        bike.setId(bikeDto.getId());
        return bike;
    }

    public Car createEntity(CarDto carDto, Car car)
    {
        car.setId(carDto.getId());
        car.setProductionDate(carDto.getProductionDate());
        car.setModel(carDto.getModel());
        car.setColor(carDto.getColor());
        return car;
    }

}
