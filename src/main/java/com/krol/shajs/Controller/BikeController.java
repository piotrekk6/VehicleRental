package com.krol.shajs.Controller;

import com.krol.shajs.Entity.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BikeController {

    private final BikeController bikeController;


    @Autowired
    public BikeController(BikeController bikeController) {
        this.bikeController = bikeController;
    }

    @RequestMapping(value = "/addBike/{id}")
    public String addBike()
    {
        return null;
        //TODO napisac dodawanie rowerow poprzez konstruktor
    }
}
