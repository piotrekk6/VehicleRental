package com.krol.shajs.controller;

import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api")
@ResponseStatus(HttpStatus.OK)
@AllArgsConstructor
public class VehicleController {


    private final VehicleService vehicleService;

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public Collection<VehicleDto> showAll() {
        return vehicleService.showAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable("id") String id) {
        vehicleService.deleteById(Long.valueOf(id));
    }

    @GetMapping
    public VehicleDto showOne(@PathVariable("id") String id) throws NotFoundException {
        return vehicleService.getVehicleDtoById(Long.valueOf(id));
    }

}
