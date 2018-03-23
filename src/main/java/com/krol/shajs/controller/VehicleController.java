package com.krol.shajs.controller;

import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api")
@ResponseStatus(HttpStatus.OK)
@AllArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping(value = "/showAll")
    public Collection<VehicleDto> showAll() {
        return vehicleService.getAllVehiclesDtoOrderById();
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable("id") String id) throws NotFoundException {
        vehicleService.deleteById(Long.valueOf(id));
    }

    @GetMapping(value = "/details/{id}")
    public VehicleDto showOne(@PathVariable("id") String id) throws NotFoundException {
        return vehicleService.getVehicleDtoById(Long.valueOf(id));
    }
}
