package com.krol.shajs.controller;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.dto.EditCarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
