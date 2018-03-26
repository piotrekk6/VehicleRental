package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.BikeCarModelMapper;
import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.repository.CarRepository;
import com.krol.shajs.service.CarService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CarServiceImpl extends BikeCarModelMapper implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car addCar(CarDto car) {
        return carRepository.save(carDtoToEntity(car));
    }

    @Override
    public Car addCar(String name) {
        CarDto carDto = new CarDto();
        carDto.setName(name);
        return carRepository.save(carDtoToEntity(carDto));
    }

    @Override
    public void editCar(CarDto editCarDto) {
        Car car = editCarDtoToEntity(editCarDto);
        carRepository.save(car);
    }


}
