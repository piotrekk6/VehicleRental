package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.BikeCarModelMapper;
import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.BorrowedVehicleDto;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.BorrowRepository;
import com.krol.shajs.service.BorrowService;
import com.krol.shajs.service.BorrowerService;
import com.krol.shajs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import static com.krol.shajs.enums_converters.ExceptionCode.VEHICLE_ALREADY_BORROWED;

@Service
public class BorrowServiceImpl extends BikeCarModelMapper implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final BorrowerService borrowerService;
    private final VehicleService vehicleService;

    @Autowired
    public BorrowServiceImpl(BorrowRepository borrowRepository, BorrowerService borrowerService, VehicleService vehicleService) {
        this.borrowRepository = borrowRepository;
        this.borrowerService = borrowerService;
        this.vehicleService = vehicleService;
    }

    @Override
    public Borrow borrowVehicle(BorrowDto borrowDto) throws NotFoundException {
        Borrower borrower = borrowerService.getBorrowerById(borrowDto.getBorrowerId());
        Vehicle vehicle = vehicleService.getVehicleByID(borrowDto.getVehicleId());
        boolean existsByDateAndVehicle = borrowRepository.existsByDateAndVehicle(borrowDto.getDate(), vehicle);
        if (!existsByDateAndVehicle) {
            Borrow borrow = new Borrow();
            borrow.borrow(borrower, vehicle, borrowDto.getDate());
            return borrowRepository.save(borrow);
        } else throw new NotFoundException(VEHICLE_ALREADY_BORROWED);


    }

    @Override
    public Collection<BorrowedVehicleDto> getBorrowedVehiclesForSpecifiedDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        Collection<Borrow> borrowCollection = borrowRepository.findByDate(localDate);
        return borrowCollection.stream().map(borrow -> borrowEntityToDto(borrow)).collect(Collectors.toList());
    }

    @Override
    public Collection<Borrow> getAllBorrows() {
        Collection<BorrowedVehicleDto> borrows = new HashSet<>();
        return borrowRepository.findAll();
    }


}
