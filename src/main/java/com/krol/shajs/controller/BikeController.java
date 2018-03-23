package com.krol.shajs.controller;

import com.krol.shajs.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @GetMapping(value = "/addBike/{name}")
    public void addBike(@PathVariable("name") String name) {
        bikeService.addBike(name);
    }
}
