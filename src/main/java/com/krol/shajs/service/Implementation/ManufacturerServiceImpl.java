package com.krol.shajs.service.Implementation;

import com.krol.shajs.entity.Manufacturer;
import com.krol.shajs.repository.ManufacturerRepository;
import com.krol.shajs.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public Manufacturer findByName(String name) {
        return manufacturerRepository.findByManufacturerName(name);
    }

    @Override
    public Manufacturer create(String name) {
        return manufacturerRepository.save(new Manufacturer(name));
    }

    /* Finds manufacturer in database by name and returns. If it doesnt exist, saves and returns new Manufacturer.*/
    public Manufacturer getManufacturer(String manufacturerName) {
        Manufacturer fetchedManufacturer = findByName(manufacturerName);
        if (fetchedManufacturer == null) {
            return create(manufacturerName);
        } else return fetchedManufacturer;
    }
}
