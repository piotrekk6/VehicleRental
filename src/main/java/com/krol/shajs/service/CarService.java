package com.krol.shajs.service;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.exceptions.NotFoundException;

public interface CarService {

    Car addCar(CarDto car);
    Car addCar(String name);
    void editCar(CarDto editCarDto) throws NotFoundException;

}
