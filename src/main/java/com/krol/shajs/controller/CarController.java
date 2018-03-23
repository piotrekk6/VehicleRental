package com.krol.shajs.controller;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class CarController {

    private final CarService carService;

    @PostMapping("/addCar/{name}")
    public void addCarByManufacturer(@PathVariable("name") String name) {
        carService.addCar(name);
    }

    @PostMapping(value = "/addCar")
    public void addCarByDto(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }

    @PutMapping(value = "/editCar")
    public void editCar(@RequestBody CarDto editCarDto) {
        carService.editCar(editCarDto);
    }
}
