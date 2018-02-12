package com.krol.shajs.Service;

import com.krol.shajs.Dto.BikeDto;
import com.krol.shajs.Entity.Bike;
import com.krol.shajs.Repository.BikeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addBike(BikeDto bike) {
        bikeRepository.save(bikeDtoToEntity(bike));
    }



    private Bike bikeDtoToEntity(BikeDto bike)
    {
        return modelMapper.map(bike, Bike.class);
    }

    private BikeDto bikeEntityToDto(Bike bike)
    {
        return modelMapper.map(bike,BikeDto.class);
    }
}
