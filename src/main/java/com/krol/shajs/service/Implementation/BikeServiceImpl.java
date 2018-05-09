package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.BikeDto;
import com.krol.shajs.enums_converters.dtoConverter.VehicleEntityDtoConverter;
import com.krol.shajs.repository.BikeRepository;
import com.krol.shajs.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BikeServiceImpl implements BikeService {


    private final BikeRepository bikeRepository;
    private final VehicleEntityDtoConverter vehicleEntityDtoConverter;

    @Override
    public void addBike(BikeDto bike) {
        bikeRepository.save(vehicleEntityDtoConverter.createEntity(bike));
    }

    @Override
    public void addBike(String name) {
        BikeDto bike = new BikeDto();
        bike.setName(name);
        addBike(bike);
    }


}
