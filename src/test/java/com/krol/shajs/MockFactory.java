package com.krol.shajs;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.BorrowerDto;
import com.krol.shajs.dto.CarDto;
import com.krol.shajs.dto.VehicleWithBorrowNameAndDateDto;
import com.krol.shajs.entity.Bike;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Manufacturer;
import com.krol.shajs.enums_converters.Color;

import java.time.LocalDate;

public final class MockFactory {

    public static BorrowerDto getBorrowerDtoMock()
    {
        BorrowerDto borrowerDto = new BorrowerDto();
        borrowerDto.setId(98L);
        borrowerDto.setFirstName("Jan");
        borrowerDto.setSecondName("Kowalski");
        return borrowerDto;
    }

    public static Borrower getBorrowerMock()
    {
        Borrower borrower = new Borrower();
        borrower.setId(98L);
        borrower.setFirstName("Jan");
        borrower.setSecondName("Kowalski");
        return borrower;
    }

    public static Car getCarMock()
    {
        Car car = new Car(new Manufacturer("Aaa"), "Bbb", Color.ORANGE, LocalDate.parse("2003-01-01"));
        car.setId(98L);
        return car;
    }

    public static CarDto getCarDtoMock()
    {
        CarDto carDto =  new CarDto("Bbb",Color.ORANGE, LocalDate.parse("2003-01-01"), "Aaa");
        carDto.setId(98L);
        return  carDto;
    }

    public static Bike getBikeMock()
    {
        Bike bike = new Bike();
        bike.setName("Ccc");
        bike.setId(100L);
        return bike;
    }

    public static BorrowDto getBorrowDtoMock()
    {
        BorrowDto borrowDto = new BorrowDto();
        borrowDto.setBorrowerId(5L);
        borrowDto.setDate(LocalDate.parse("2000-12-12"));
        borrowDto.setVehicleId(2L);
        return borrowDto;
    }
    public static Borrow getBorrowMock()
    {
        Borrow borrow =new Borrow();
        borrow.setId(4L);
        borrow.setBorrower(getBorrowerMock());
        borrow.setDate(LocalDate.parse("2018-05-05"));
        borrow.setVehicle(getCarMock());
        return borrow;
    }
     public static VehicleWithBorrowNameAndDateDto getVehicleWithBorrowNameAndDateDto(long id)
     {
         VehicleWithBorrowNameAndDateDto vehicle = new VehicleWithBorrowNameAndDateDto();
         vehicle.setId(15L);
         vehicle.setName("");
         return null;
     }
}
