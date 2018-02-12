package com.krol.shajs.Controller;

import com.krol.shajs.Dto.CarDto;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Service.CarService;
import com.krol.shajs.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CarController {


    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/addCar/{brand}")
    public void addCar(@PathVariable("brand") String brand)
    {
        CarDto car = new CarDto();
        car.setBrand(brand);
        carService.addCar(car);
    }


}
