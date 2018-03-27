package com.krol.shajs.service.Implementation;

import com.krol.shajs.entity.Manufacturer;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.ManufacturerRepository;
import com.krol.shajs.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer findByName(String name) {
        return  manufacturerRepository.findByName(name);
    }

    @Override
    public Manufacturer create(String name) {
        return manufacturerRepository.save(new Manufacturer(name));
    }
}
