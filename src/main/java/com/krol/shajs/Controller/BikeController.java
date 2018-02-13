package com.krol.shajs.Controller;

import com.krol.shajs.Dto.BikeDto;
import com.krol.shajs.Entity.Bike;
import com.krol.shajs.Service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/addBike/{manufacturer}")
    public void addBike(@PathVariable("manufacturer") String manufacturer) {

        BikeDto bike = new BikeDto();
        bike.setManufacturer(manufacturer);
        bikeService.addBike(bike);

    }
}
