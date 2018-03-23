package com.krol.shajs.dto;

import com.krol.shajs.entity.Bike;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BikeCarModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    protected Car carDtoToEntity(CarDto carDto) {
        return modelMapper.map(carDto, Car.class);
    }

    protected CarDto carEntityToDto(Car car) {
        return modelMapper.map(car, CarDto.class);
    }

    protected Bike bikeDtoToEntity(BikeDto bike) {
        return modelMapper.map(bike, Bike.class);
    }

    protected VehicleDto vehicleEntityToDto(Vehicle vehicle) {
        if (vehicle.isBike()) {
            return modelMapper.map(vehicle, BikeDto.class);
        } else if (vehicle.isCar()) {
            return modelMapper.map(vehicle, CarDto.class);
        }
        return null; //TODO return exception
    }

    protected Car editCarDtoToEntity(CarDto editCarDto) {
        return modelMapper.map(editCarDto, Car.class);
    }

    protected CarDto carEntityToEditCarDto(Car car) {
        return modelMapper.map(car, CarDto.class);
    }

    protected VehicleWithBorrowNameAndDateDto vehicleEntityToFlatDto(Vehicle vehicle) {
        VehicleDto vehicleDto = vehicleEntityToDto(vehicle);
        return modelMapper.map(vehicleDto, VehicleWithBorrowNameAndDateDto.class);
    }
}
