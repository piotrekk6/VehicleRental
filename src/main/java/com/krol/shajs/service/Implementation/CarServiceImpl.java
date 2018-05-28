package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Manufacturer;
import com.krol.shajs.enums_converters.dtoConverter.VehicleEntityDtoConverter;
import com.krol.shajs.exceptions.ApplicationException;
import com.krol.shajs.repository.CarRepository;
import com.krol.shajs.service.CarService;
import com.krol.shajs.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.krol.shajs.enums_converters.ExceptionCode.*;

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ManufacturerService manufacturerService;
    private final VehicleEntityDtoConverter vehicleEntityDtoConverter;

    @Override
    public Car addCar(CarDto carDto) {
        Manufacturer manufacturer = manufacturerService.getManufacturer(carDto.getManufacturerName());
        Car car = vehicleEntityDtoConverter.createEntity(carDto);
        car.setManufacturer(manufacturer);
        return carRepository.save(car);
    }

    @Override
    public Long addCar(String name) {
        Car car = new Car();
        car.setManufacturer(manufacturerService.getManufacturer(name));
        return carRepository.save(car).getId();
    }

    @Override
    public void editCar(CarDto carDto) throws ApplicationException {
        Car car = carRepository.findById(carDto.getId());
        car =  Optional.ofNullable(car)
                       .map(car1 -> vehicleEntityDtoConverter.createEntity(carDto, car1))
                       .orElseThrow(() -> new ApplicationException(VEHICLE_NOT_FOUND));
        car.setManufacturer(manufacturerService.getManufacturer(carDto.getManufacturerName()));
        carRepository.save(car);
    }

}
