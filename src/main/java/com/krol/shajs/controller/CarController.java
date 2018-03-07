package com.krol.shajs.controller;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.dto.EditCarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class CarController {
    private final CarService carService;

    @PostMapping("/addCar/{name}")
    public void addCarByManufacturer(@PathVariable("name") String name) {
        CarDto carDto = new CarDto();
        carDto.setName(name);
        carService.addCar(carDto);
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public void addCarByDto(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }

    @PutMapping(value = "/editCar")
    public void editCar(@RequestBody EditCarDto editCarDto) {
        carService.editCar(editCarDto);
    }
}
