package com.krol.shajs.controller;

import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api")
public class VehicleController {


    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public Collection<VehicleDto> showAll() {
        return vehicleService.showAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") String id)
    {
        vehicleService.deleteById(Long.valueOf(id));
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public VehicleDto showOne(@PathVariable("id") String id) throws NotFoundException {
        return vehicleService.getVehicleDtoById(Long.valueOf(id));
    }

}
