package com.krol.shajs.controller;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api")
@ResponseStatus(HttpStatus.OK)
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/addCar/{manufacturer}")
    public void addCarByManufacturer(@PathVariable("manufacturer") String manufacturerName) {
        carService.addCar(manufacturerName);
    }

    @PostMapping(value = "/addCar")
    @ResponseStatus(CREATED)
    public void addCarByDto(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }

    @PutMapping(value = "/editCar")
    public void editCar(@RequestBody CarDto editCarDto) throws NotFoundException {
        carService.editCar(editCarDto);
    }
}
