package com.krol.shajs.configuration;

import com.krol.shajs.dto.BorrowedVehicleDto;
import com.krol.shajs.entity.Borrow;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper m1 = new ModelMapper();
        m1.addMappings(new PropertyMap<Borrow, BorrowedVehicleDto>() {
            @Override
            protected void configure() {
                map().setVehicleType(source.getVehicle().getVehicleType());
                map().setVehicleName(source.getVehicle().getName());
                map().setBorrowDate(source.getDate());
                map().setBorrowerName(source.getBorrower().getFirstName());
            }
        });
        return m1;
    }
}
