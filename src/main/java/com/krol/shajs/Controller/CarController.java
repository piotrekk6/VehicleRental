package com.krol.shajs.Controller;

import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CarController {

    private final VehicleService vehicleService;

    @Autowired
    public CarController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public Collection<Vehicle> showAll() {
        return vehicleService.showAll();
    }
}
