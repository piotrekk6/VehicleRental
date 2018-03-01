package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.BikeCarModelMapper;
import com.krol.shajs.dto.CarDto;
import com.krol.shajs.dto.EditCarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.repository.CarRepository;
import com.krol.shajs.service.CarService;
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
