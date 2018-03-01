package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.BikeCarModelMapper;
import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.enums_converters.ExceptionCode;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.VehicleRepository;
import com.krol.shajs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl extends BikeCarModelMapper implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> showAll() {
        List<Vehicle> vehicleResultList = vehicleRepository.findAll();

        return vehicleResultList.stream().map(vehicle -> this.vehicleEntityToDto(vehicle)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        vehicleRepository.delete(id);
    }

    @Override
    public VehicleDto getVehicleDtoById(Long id) throws NotFoundException {
        Vehicle vehicle = getVehicleByID(id);

        return vehicleEntityToDto(vehicle);
    }

    public Vehicle getVehicleByID(Long id) throws NotFoundException {
        Vehicle vehicle = vehicleRepository.findOne(id);
        if (vehicle == null) throw new NotFoundException(ExceptionCode.VEHICLE_NOT_FOUND);
        else return vehicle;

    }

    @Override
    public Collection<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}
