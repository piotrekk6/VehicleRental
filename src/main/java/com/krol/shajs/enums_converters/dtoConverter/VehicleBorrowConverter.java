package com.krol.shajs.enums_converters.dtoConverter;


import com.krol.shajs.dto.VehicleWithBorrowNameAndDateDto;
import com.krol.shajs.entity.Bike;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleBorrowConverter {

    public VehicleWithBorrowNameAndDateDto createDto(Vehicle vehicle)
    {
        VehicleWithBorrowNameAndDateDto vehicleBorrowDto = new VehicleWithBorrowNameAndDateDto();
        vehicleBorrowDto.setId(vehicle.getId());
        vehicleBorrowDto.setVehicleType(vehicle.getVehicleType());
        if(vehicle.isBike())
        {
            vehicleBorrowDto.setName(((Bike) vehicle).getName());
        }
        else if (vehicle.isCar())
        {
            vehicleBorrowDto.setColor(((Car) vehicle).getColor());
            vehicleBorrowDto.setManufacturerName(((Car) vehicle).getManufacturer().getManufacturerName());
            vehicleBorrowDto.setModel(((Car) vehicle).getModel());
            vehicleBorrowDto.setProductionDate(((Car) vehicle).getProductionDate());
        }
        return vehicleBorrowDto;
    }
}
