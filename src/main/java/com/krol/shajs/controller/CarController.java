package com.krol.shajs.controller;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class CarController {

    private final CarService carService;

    @PostMapping("/addCar/{manufacturer}")
    public void addCarByManufacturer(@PathVariable("manufacturer") String manufacturerName) {
        carService.addCar(manufacturerName);
    }//todo return url of newly added element

    @PostMapping(value = "/addCar")
    @ResponseStatus(CREATED)
    public void addCarByDto(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }//todo return url of newly added element

    @PutMapping(value = "/editCar")
    public void editCar(@RequestBody CarDto editCarDto) {
        carService.editCar(editCarDto);
    }
}
