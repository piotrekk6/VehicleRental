package com.krol.shajs.controller;

import com.krol.shajs.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api")
public class BikeController {

    private final BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @PostMapping(value = "/addBike/{name}")
    @ResponseStatus(CREATED)
    public void addBike(@PathVariable("name") String name) {
        bikeService.addBike(name);
    }
}
