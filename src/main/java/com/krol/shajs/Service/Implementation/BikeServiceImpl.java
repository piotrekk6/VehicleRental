package com.krol.shajs.Service.Implementation;

import com.krol.shajs.Dto.BikeCarModelMapper;
import com.krol.shajs.Dto.BikeDto;
import com.krol.shajs.Entity.Bike;
import com.krol.shajs.Repository.BikeRepository;
import com.krol.shajs.Service.BikeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BikeServiceImpl extends BikeCarModelMapper implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public void addBike(BikeDto bike) {
        bikeRepository.save(bikeDtoToEntity(bike));
    }



}
