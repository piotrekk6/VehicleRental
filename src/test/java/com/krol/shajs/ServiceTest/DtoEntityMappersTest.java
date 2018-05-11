package com.krol.shajs.ServiceTest;

import com.krol.shajs.dto.BikeDto;
import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Bike;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Manufacturer;
import com.krol.shajs.enums_converters.Color;
import com.krol.shajs.enums_converters.dtoConverter.VehicleEntityDtoConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static com.krol.shajs.enums_converters.Color.BLACK;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DtoEntityMappersTest {

    @Autowired
    private VehicleEntityDtoConverter vehicleEntityDtoConverter;

    @Test
    public void test_createCarDto() {
        //given
        Car car = new Car(new Manufacturer("Nissan"), "350z", BLACK, LocalDate.parse("2018-12-12"));
        car.setId(5L);

        //when
        CarDto carDto = (CarDto) vehicleEntityDtoConverter.createDto(car);

        //then
        Assert.assertEquals(car.getId(), carDto.getId());
        Assert.assertEquals(car.getColor(), carDto.getColor());
        Assert.assertEquals(car.getManufacturer().getManufacturerName(), carDto.getManufacturerName());
        Assert.assertEquals(car.getProductionDate(), carDto.getProductionDate());
    }

    @Test
    public void test_createBikeDto() {
        //given
        Bike bike = new Bike();
        bike.setId(10L);
        bike.setName("Mountain");

        //when
        BikeDto bikeDto = (BikeDto) vehicleEntityDtoConverter.createDto(bike);

        //then
        Assert.assertEquals(bike.getId(), bikeDto.getId());
        Assert.assertEquals(bike.getName(), bikeDto.getName());
        Assert.assertEquals(bike.getVehicleType(), bikeDto.getVehicleType());
    }

    @Test
    public void test_createBikeEntity() {
        BikeDto bikeDto = new BikeDto();
        bikeDto.setId(4L);
        bikeDto.setName("Pol");

        Bike bike = vehicleEntityDtoConverter.createEntity(bikeDto);

        Assert.assertEquals(bikeDto.getId(), bike.getId());
        Assert.assertEquals(bikeDto.getName(), bike.getName());
    }

    @Test
    public void test_createCarEntity() {
        CarDto carDto = new CarDto("Fast", Color.RED, LocalDate.parse("2010-01-01"), "Furious");
        carDto.setId(39L);

        Car car = vehicleEntityDtoConverter.createEntity(carDto);

        Assert.assertEquals(carDto.getId(), car.getId());
        Assert.assertEquals(carDto.getProductionDate(), car.getProductionDate());
        Assert.assertEquals(carDto.getColor(), car.getColor());
        Assert.assertEquals(carDto.getModel(), car.getModel());
    }

    //test if mapped values from dto to entity, and if given entity in parameter object is the same as returned
    @Test
    public void test_mapCarEntity() {
        CarDto carDto = new CarDto("Fast", Color.RED, LocalDate.parse("2010-01-01"), "Furious");
        carDto.setId(39L);
        Car car = new Car();

        car = vehicleEntityDtoConverter.createEntity(carDto, car);

        Assert.assertEquals(carDto.getId(), car.getId());
        Assert.assertEquals(carDto.getProductionDate(), car.getProductionDate());
        Assert.assertEquals(carDto.getColor(), car.getColor());
        Assert.assertEquals(carDto.getModel(), car.getModel());
    }
}
