package com.krol.shajs.service;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.dto.EditCarDto;
import com.krol.shajs.entity.Car;

public interface CarService {

    Car addCar(CarDto car);
    Car editCar(EditCarDto editCarDto);

}
