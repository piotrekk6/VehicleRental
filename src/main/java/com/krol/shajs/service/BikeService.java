package com.krol.shajs.service;

import com.krol.shajs.dto.BikeDto;

public interface BikeService {
    void addBike(BikeDto bike);
    void addBikeByName(String name);
}