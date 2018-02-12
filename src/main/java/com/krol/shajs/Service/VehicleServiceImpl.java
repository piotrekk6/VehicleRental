package com.krol.shajs.Service;

import com.krol.shajs.Configuration.ModelMapperConfiguration;
import com.krol.shajs.Dto.VehicleDto;
import com.krol.shajs.Entity.Bike;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Vehicle> showAll() {
        return null;
    }

/*    @Override
    public List<VehicleDto> showAll() {
        List<Vehicle> vehicleResultList = vehicleRepository.findAll();
        for (Vehicle vehicle : vehicleResultList) {

        }
    }*/
}
