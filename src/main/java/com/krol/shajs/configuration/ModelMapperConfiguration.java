package com.krol.shajs.configuration;

import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper m1 = new ModelMapper();
/*        m1.addMappings(new PropertyMap<Car, CarDto>() {

            @Override
            protected void configure() {
                map().setManufacturerName(source.getManufacturer().getManufacturerName());
            }
        });*/
        return m1;
    }
}
