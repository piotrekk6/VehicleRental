package com.krol.shajs.controller;

import com.krol.shajs.dto.BikeDto;
import com.krol.shajs.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class BikeController {

    private final BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    } // wstrzykiwanie lombokiem

    @GetMapping(value = "/addBike/{name}")
    public void addBike(@PathVariable("name") String name) {
        bikeService.addBikeByName(name);
    } // nazewnictwo
}
