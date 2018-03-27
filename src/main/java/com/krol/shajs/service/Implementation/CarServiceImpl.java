package com.krol.shajs.service.Implementation;

import com.krol.shajs.enums_converters.dtoConverter.BikeCarModelMapper;
import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Manufacturer;
import com.krol.shajs.enums_converters.dtoConverter.CarEntityDtoConverter;
import com.krol.shajs.repository.CarRepository;
import com.krol.shajs.service.CarService;
import com.krol.shajs.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl extends BikeCarModelMapper implements CarService {

    private final CarRepository carRepository;
    private final ManufacturerService manufacturerService;
    private final CarEntityDtoConverter carEntityDtoConverter;

    @Override
    public Car addCar(CarDto carDto) {
        Manufacturer manufacturer = manufacturerService.getManufacturer(carDto.getManufacturerName());
        Car car = carEntityDtoConverter.createEntity(carDto);
        car.setManufacturer(manufacturer);
        return carRepository.save(car);
    }

    @Override
    public Car addCar(String name) {
        Car car = new Car();
        car.setManufacturer(manufacturerService.getManufacturer(name));
        return carRepository.save(car);
    }

    @Override
    public void editCar(CarDto editCarDto) {
        Car car = carEntityDtoConverter.createEntity(editCarDto);
        car.setManufacturer(manufacturerService.getManufacturer(editCarDto.getManufacturerName()));
        carRepository.save(car);
    }

}
