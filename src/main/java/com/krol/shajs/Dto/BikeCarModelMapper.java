package com.krol.shajs.Dto;

import com.krol.shajs.Entity.Bike;
import com.krol.shajs.Entity.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BikeCarModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Car carDtoToEntity(CarDto carDto)
    {
        return modelMapper.map(carDto, Car.class);
    }

    public CarDto carEntityToDto(Car car)
    {
        return modelMapper.map(car,CarDto.class);
    }

    public Bike bikeDtoToEntity(BikeDto bike)
    {
        return modelMapper.map(bike, Bike.class);
    }

    public BikeDto bikeEntityToDto(Bike bike)
    {
        return modelMapper.map(bike,BikeDto.class);
    }

    public Car editCarDtoToEntity(EditCarDto editCarDto)
    {
        return modelMapper.map(editCarDto, Car.class);
    }

    public EditCarDto editCarEntityToDto(Car car)
    {
        return modelMapper.map(car, EditCarDto.class);
    }

}
