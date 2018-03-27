package com.krol.shajs.enums_converters.dtoConverter;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarEntityDtoConverter {

    public CarDto createDto(Car car)
    {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setColor(car.getColor());
        carDto.setModel(car.getModel());
        carDto.setProductionDate(car.getProductionDate());
        carDto.setVehicleType(car.getVehicleType());
        carDto.setManufacturerName(car.getManufacturer().getName());
        return carDto;
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
}
