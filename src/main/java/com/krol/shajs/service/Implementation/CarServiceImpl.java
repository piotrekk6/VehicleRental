package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.BikeCarModelMapper;
import com.krol.shajs.dto.CarDto;
import com.krol.shajs.dto.EditCarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.repository.CarRepository;
import com.krol.shajs.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl extends BikeCarModelMapper implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car addCar(CarDto car) {
        return carRepository.save(carDtoToEntity(car));
    }

    @Override
    public void editCar(EditCarDto editCarDto) {
        Car car = editCarDtoToEntity(editCarDto);
        carRepository.save(car);
    }


}
