package com.krol.shajs.controller;

import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/vehicles")
@ResponseStatus(HttpStatus.OK)
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public Collection<VehicleDto> showAll() {
        return vehicleService.getAllVehiclesOrderById();
    }

    @DeleteMapping(value = "/{id}/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable("id") String id) throws NotFoundException {
        vehicleService.deleteById(Long.valueOf(id));
    }

    @GetMapping(value = "/{id}")
    public VehicleDto showOne(@PathVariable("id") String id) throws NotFoundException {
        return vehicleService.getVehicleById(Long.valueOf(id));
    }
}
