package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.*;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.enums_converters.dtoConverter.BorrowEntityDtoConverter;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.BorrowRepository;
import com.krol.shajs.service.BorrowService;
import com.krol.shajs.service.BorrowerService;
import com.krol.shajs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.krol.shajs.enums_converters.ExceptionCode.VEHICLE_ALREADY_BORROWED;

@Service
public class BorrowServiceImpl extends BikeCarModelMapper implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final BorrowerService borrowerService;
    private final VehicleService vehicleService;
    private final BorrowEntityDtoConverter borrowEntityDtoConverter;

    @Autowired
    public BorrowServiceImpl(BorrowRepository borrowRepository, BorrowerService borrowerService, VehicleService vehicleService, BorrowEntityDtoConverter borrowEntityDtoConverter) {
        this.borrowRepository = borrowRepository;
        this.borrowerService = borrowerService;
        this.vehicleService = vehicleService;
        this.borrowEntityDtoConverter = borrowEntityDtoConverter;
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
    public List<VehicleDto> getBorrowedVehiclesForSpecifiedDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        Collection<VehicleBorrowDto> vehicles = vehicleService.getAll().stream().map(this::borrowEntityToDto).collect(Collectors.toCollection());
        vehicleDtos.forEach(vehicleDto -> {
            try {
                Borrow borrow = borrowRepository.findByDateAndVehicle(localDate, vehicleService.getVehicleByID(vehicleDto.getId());
                if(borrow != null){
                    vehicleDto.setBorrowed();
                }
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
        return vehicleDtos;
    }

    @Override
    public Collection<BorrowedVehicleDto> getAllBorrows() {
        return borrowRepository.findAll().stream()
                               .map(borrowEntityDtoConverter::createDto)
                               .collect(Collectors.toList());
    }
}
