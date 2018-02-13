package com.krol.shajs.Service;

import com.krol.shajs.Dto.BikeCarModelMapper;
import com.krol.shajs.Dto.CarDto;
import com.krol.shajs.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends BikeCarModelMapper implements CarService{

    @Autowired
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(CarDto car) {
        carRepository.save(carDtoToEntity(car));
    }




}
