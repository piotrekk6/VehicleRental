package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.BikeCarModelMapper;
import com.krol.shajs.dto.BikeDto;
import com.krol.shajs.repository.BikeRepository;
import com.krol.shajs.service.BikeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BikeServiceImpl extends BikeCarModelMapper implements BikeService {

    private BikeRepository bikeRepository;

    @Override
    public void addBike(BikeDto bike) {
        bikeRepository.save(bikeDtoToEntity(bike));
    }

    @Override
    public void addBike(String name) {
        BikeDto bike = new BikeDto();
        bike.setName(name);
        addBike(bike);
    }


}
