package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.VehicleDto;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.enums_converters.dtoConverter.VehicleEntityDtoConverter;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.VehicleRepository;
import com.krol.shajs.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.krol.shajs.enums_converters.ExceptionCode.VEHICLE_NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleEntityDtoConverter vehicleEntityDtoConverter;

    @Override
    public List<VehicleDto> getAllVehiclesOrderById() {
        Set<Vehicle> vehicleResultList = vehicleRepository.findAllByOrderById();
        return vehicleResultList
                .stream()
                .map(vehicleEntityDtoConverter::createDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        vehicleRepository.delete(getVehicleByID(id));
    }

    @Override
    public VehicleDto getVehicleById(Long id) throws NotFoundException {
        Vehicle vehicle = getVehicleByID(id);
        return vehicleEntityDtoConverter.createDto(vehicle);
    }

    public Vehicle getVehicleByID(Long id) throws NotFoundException {
        Vehicle vehicle = vehicleRepository.findOne(id);
        if (vehicle == null) throw new NotFoundException(VEHICLE_NOT_FOUND);
        else return vehicle;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}
