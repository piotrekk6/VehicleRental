package com.krol.shajs.dto;

import com.krol.shajs.entity.Bike;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.enums_converters.VehicleType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BikeCarModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Car carDtoToEntity(CarDto carDto) {
        return modelMapper.map(carDto, Car.class);
    }

    public CarDto carEntityToDto(Car car) {
        return modelMapper.map(car, CarDto.class);
    }

    public Bike bikeDtoToEntity(BikeDto bike) {
        return modelMapper.map(bike, Bike.class);
    }

    public VehicleDto vehicleEntityToDto(Vehicle vehicle) {
        if (vehicle.isBike()) {
            return modelMapper.map(vehicle, BikeDto.class);
        } else if (vehicle.isCar()) {
            return modelMapper.map(vehicle, CarDto.class);
        }
        return null; //TODO return exception
    }

    public Car editCarDtoToEntity(EditCarDto editCarDto) {
        return modelMapper.map(editCarDto, Car.class);
    }

    public EditCarDto carEntityToEditCarDto(Car car) {
        return modelMapper.map(car, EditCarDto.class);
    }

}
