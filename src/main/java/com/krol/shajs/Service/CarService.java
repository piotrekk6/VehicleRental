package com.krol.shajs.Service;

import com.krol.shajs.Dto.CarDto;
import com.krol.shajs.Dto.EditCarDto;
import com.krol.shajs.Entity.Car;
import com.krol.shajs.Exceptions.NotFoundException;

public interface CarService {

    Car addCar(CarDto car);
    Car editCar(EditCarDto editCarDto);

}
