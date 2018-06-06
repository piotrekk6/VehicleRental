package com.krol.shajs.controller;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.exceptions.VehicleRentApplicationException;
import com.krol.shajs.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/vehicles/cars")
@ResponseStatus(OK)
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/{manufacturer}")
    public ResponseEntity<Car> addCarByManufacturer(@PathVariable("manufacturer") String manufacturerName) {
        Long id = carService.addCar(manufacturerName);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/vehicles/"+id)
                .build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void addCarByDto(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }

    @PutMapping(value = "/edit")
    public void editCar(@RequestBody CarDto editCarDto) throws VehicleRentApplicationException {
        carService.editCar(editCarDto);
    }
}
