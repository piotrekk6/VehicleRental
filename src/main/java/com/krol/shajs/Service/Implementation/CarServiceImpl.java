package com.krol.shajs.Service.Implementation;

import com.krol.shajs.Dto.BikeCarModelMapper;
import com.krol.shajs.Dto.CarDto;
import com.krol.shajs.Dto.EditCarDto;
import com.krol.shajs.Entity.Car;
import com.krol.shajs.Repository.CarRepository;
import com.krol.shajs.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends BikeCarModelMapper implements CarService {

    @Autowired
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(CarDto car) {
        return carRepository.save(carDtoToEntity(car));
    }

    @Override
    public Car editCar(EditCarDto editCarDto) {
        Car car = editCarDtoToEntity(editCarDto);
        return carRepository.save(car);
    }


}
