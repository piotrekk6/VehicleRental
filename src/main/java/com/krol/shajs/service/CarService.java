package com.krol.shajs.service;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.exceptions.VehicleRentApplicationException;

public interface CarService {

    Car addCar(CarDto car);
    Long addCar(String name);
    void editCar(CarDto editCarDto) throws VehicleRentApplicationException;

}
