package com.krol.shajs.enums_converters.dtoConverter;

import com.krol.shajs.dto.BikeDto;
import com.krol.shajs.dto.BorrowedVehicleDto;
import com.krol.shajs.dto.BorrowerDto;
import com.krol.shajs.dto.CarDto;
import com.krol.shajs.entity.Bike;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class BorrowEntityDtoConverter {

    public BorrowedVehicleDto createDto(Borrow borrowEntity) {

        BorrowedVehicleDto borrowDto = new BorrowedVehicleDto();
        if (borrowEntity.getVehicle().isCar()) {
            Car car = (Car) borrowEntity.getVehicle();
            CarDto vehicleDto = new CarDto();
            //vehicleDto.setName(car.getName());
            vehicleDto.setVehicleType(car.getVehicleType());
            vehicleDto.setProductionDate(car.getProductionDate());
            vehicleDto.setModel(car.getModel());
            vehicleDto.setColor(car.getColor());
            vehicleDto.setId(car.getId());
            borrowDto.setVehicleDto(vehicleDto);
        } else if (borrowEntity.getVehicle().isBike()) {
            Bike bike = (Bike) borrowEntity.getVehicle();
            BikeDto vehicleDto = new BikeDto();
            vehicleDto.setId(bike.getId());
            vehicleDto.setName(bike.getName());
            vehicleDto.setVehicleType(bike.getVehicleType());
            borrowDto.setVehicleDto(vehicleDto);
        }

        BorrowerDto borrowerDto = new BorrowerDto(borrowEntity.getBorrower().getFirstName(), borrowEntity.getBorrower().getSecondName());
        borrowDto.setId(borrowEntity.getId());
        borrowDto.setBorrowerDto(borrowerDto);
        borrowDto.setDate(borrowEntity.getDate());
        return borrowDto;
    }

}
