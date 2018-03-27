package com.krol.shajs.service;

import com.krol.shajs.entity.Manufacturer;

public interface ManufacturerService {
    Manufacturer findByName(String name);
    Manufacturer create(String name);
}
