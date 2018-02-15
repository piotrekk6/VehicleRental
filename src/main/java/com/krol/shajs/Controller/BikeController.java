package com.krol.shajs.Controller;

import com.krol.shajs.Dto.BikeDto;
import com.krol.shajs.Entity.Bike;
import com.krol.shajs.Service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BikeController {


    private final BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping(value = "/addBike/{number}")
    public void addBike(@PathVariable("number") String number) {

        BikeDto bike = new BikeDto();
        bike.setNumber(number);
        bikeService.addBike(bike);

    }
}
