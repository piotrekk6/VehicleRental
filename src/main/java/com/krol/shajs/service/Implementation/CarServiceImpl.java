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
        Manufacturer manufacturer = getManufacturer(carDto.getManufacturerName());
        carDto.setManufacturerName(manufacturer.getName());
        return carRepository.save(carEntityDtoConverter.createEntity(carDto));
    }

    @Override
    public Car addCar(String name) {
        Car car = new Car();
        car.setManufacturer(getManufacturer(name));
        return carRepository.save(car);
    }

    @Override
    public void editCar(CarDto editCarDto) {
        Car car = editCarDtoToEntity(editCarDto);
        carRepository.save(car);
    }

   /* Finds manufacturer in database by name and returns. If it doesnt exist saves and returns new Manufacturer.*/
    private Manufacturer getManufacturer(String manufacturerName)
    {
        Manufacturer fetchedManufacturer = manufacturerService.findByName(manufacturerName);
        if (fetchedManufacturer == null) {
            return manufacturerService.create(manufacturerName);
        }
        return fetchedManufacturer;


    }
}
