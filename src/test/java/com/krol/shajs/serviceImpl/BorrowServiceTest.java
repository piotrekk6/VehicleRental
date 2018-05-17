package com.krol.shajs.serviceImpl;

import com.krol.shajs.MockFactory;
import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.entity.Bike;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.entity.Car;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.enums_converters.dtoConverter.BorrowEntityDtoConverter;
import com.krol.shajs.enums_converters.dtoConverter.VehicleBorrowConverter;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.BorrowRepository;
import com.krol.shajs.service.BorrowService;
import com.krol.shajs.service.BorrowerService;
import com.krol.shajs.service.Implementation.BorrowServiceImpl;
import com.krol.shajs.service.VehicleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BorrowServiceTest {

    private BorrowService borrowService;
    @MockBean
    private  BorrowRepository borrowRepository;
    @MockBean
    private  BorrowerService borrowerService;
    @MockBean
    private  VehicleService vehicleService;
    @MockBean
    private  BorrowEntityDtoConverter borrowEntityDtoConverter;
    @MockBean
    private  VehicleBorrowConverter vehicleBorrowConverter;

    @Before
    public void beforeMethod()
    {
        borrowService = new BorrowServiceImpl(borrowRepository,borrowerService,vehicleService,borrowEntityDtoConverter,vehicleBorrowConverter);
    }
    @Test
    public void shouldMakeNewBorrowOfVehicle() throws NotFoundException {
        //given: borrowDto from frontEnd
        BorrowDto borrowDto = MockFactory.getBorrowDtoMock();
        Borrow expectedBorrowMock = new Borrow(5L,borrowDto.getDate(),MockFactory.getCarMock(),MockFactory.getBorrowerMock());
        when(borrowerService.getBorrowerById(anyLong())).thenReturn(expectedBorrowMock.getBorrower());
        when(vehicleService.getVehicleByID(anyLong())).thenReturn(expectedBorrowMock.getVehicle());
        when(borrowRepository.existsByDateAndVehicle(any(LocalDate.class),any(Vehicle.class))).thenReturn(false);

        //when
        borrowService.borrowVehicle(borrowDto);
        //then
        ArgumentCaptor<Borrow> borrowArgumentCaptor= ArgumentCaptor.forClass(Borrow.class);
        verify(borrowRepository).save(borrowArgumentCaptor.capture());
        Borrow borrow1 = borrowArgumentCaptor.getValue();

        Assert.assertEquals(expectedBorrowMock.getDate(), borrow1.getDate());
        Assert.assertEquals(expectedBorrowMock.getBorrower().getId(), borrow1.getBorrower().getId());
        Assert.assertEquals(expectedBorrowMock.getBorrower().getSecondName(), borrow1.getBorrower().getSecondName());
        Assert.assertEquals(expectedBorrowMock.getBorrower().getFirstName(), borrow1.getBorrower().getFirstName());
        Assert.assertEquals(expectedBorrowMock.getVehicle().getId(), borrow1.getVehicle().getId());
        Assert.assertEquals(expectedBorrowMock.getVehicle().getVehicleType(), borrow1.getVehicle().getVehicleType());
    }

    @Test
    public void shouldReturnListOfCarsWithInfoAboutBorrowForSpecifiedDate() throws NotFoundException {
        //given: Date from frontend
        String borrowDate = "2018-05-03";
        Car carMock =  MockFactory.getCarMock();
        Bike bikeMock = MockFactory.getBikeMock();
        Borrower borrowerMock = MockFactory.getBorrowerMock();
        Borrow borrowMock= new Borrow();
        borrowMock.setVehicle(carMock);
        borrowMock.setBorrower(borrowerMock);
        borrowMock.setId(16L);
        borrowMock.setDate(LocalDate.parse("2017-01-01"));

        when(vehicleService.getAll()).thenReturn(Arrays.asList(bikeMock, carMock));
        when(borrowRepository.findByDateAndVehicle(any(), any(Bike.class))).thenReturn(MockFactory.getBorrowMock());
        when(borrowRepository.findByDateAndVehicle(any(), any(Car.class))).thenReturn(MockFactory.getBorrowMock());
        //when(vehicleBorrowConverter.createDto(any(Bike.class))).thenReturn()
        //when(vehicleBorrowConverter.createDto(any(Car.class))).thenReturn()


        //when
        //List<VehicleWithBorrowNameAndDateDto> allVehiclesWithBorrowInfoForSpecifiedDate = borrowService.getAllVehiclesWithBorrowInfoForSpecifiedDate(borrowDate);

        //then

    }
}
