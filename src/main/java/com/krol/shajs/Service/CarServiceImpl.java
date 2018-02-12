package com.krol.shajs.Service;

import com.krol.shajs.Dto.CarDto;
import com.krol.shajs.Entity.Car;
import com.krol.shajs.Repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCar(CarDto car) {
        carRepository.save(carDtoToEntity(car));
    }



    private Car carDtoToEntity(CarDto carDto)
    {
        return modelMapper.map(carDto, Car.class);
    }

    private CarDto carEntityToDto(Car car)
    {
        return modelMapper.map(car,CarDto.class);
    }
}
