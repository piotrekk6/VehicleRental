package com.krol.shajs.Controller;

import com.krol.shajs.Dto.CarDto;
import com.krol.shajs.Dto.EditCarDto;
import com.krol.shajs.Dto.VehicleDto;
import com.krol.shajs.Entity.Car;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Service.CarService;
import com.krol.shajs.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CarController {


    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/addCar/{name}")
    public void addCarByManufacturer(@PathVariable("name") String name) {
        CarDto carDto = new CarDto();
        carDto.setName(name);
        carService.addCar(carDto);
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public ResponseEntity<Car> addCarByDto(@RequestBody CarDto carDto) {

        return ResponseEntity.ok(carService.addCar(carDto));
    }

    @PutMapping(value = "/editCar")
    public ResponseEntity<Car> editCar(@RequestBody EditCarDto editCarDto) {
        return ResponseEntity.ok(carService.editCar(editCarDto));
    }
}
