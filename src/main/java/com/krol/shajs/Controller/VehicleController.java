package com.krol.shajs.Controller;

import com.krol.shajs.Dto.VehicleDto;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
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
    public VehicleDto showOne(@PathVariable("id") String id)
    {
        return vehicleService.showOne(Long.valueOf(id));
    }
}
