package com.krol.shajs.Service.Implementation;

import com.krol.shajs.Dto.BorrowDto;
import com.krol.shajs.Dto.VehicleDto;
import com.krol.shajs.Dto.VehicleIfBorrowed;
import com.krol.shajs.Entity.Borrow;
import com.krol.shajs.Entity.Borrower;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Exceptions.NotFoundException;
import com.krol.shajs.Repository.BorrowRepository;
import com.krol.shajs.Service.BorrowService;
import com.krol.shajs.Service.BorrowerService;
import com.krol.shajs.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

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
        Borrow borrow = new Borrow();
        borrow.setVehicle(vehicle);
        borrow.setBorrower(borrower);
        borrow.setDate(borrowDto.getDate());
        return borrowRepository.save(borrow);
    }

    @Override
    public Collection<VehicleIfBorrowed> getBorrowedVehiclesForSpecifiedDate(LocalDate date)
    {
        Collection<Borrow> borrowCollection = borrowRepository.findByDate(date);
        Collection<Vehicle> vehiclesAllCollection = vehicleService.getAll();
        Collection<VehicleIfBorrowed> vehicleIfBorrowed = new HashSet<>();


        for(Borrow borrow : borrowCollection)
        {
            vehiclesAllCollection.remove(borrow.getVehicle());
            vehicleIfBorrowed.add(new VehicleIfBorrowed(borrow.getVehicle().getId(),borrow.getVehicle().getVehicleType(),true,borrow.getBorrower().getId(),borrow.getBorrower().getFirstName(),borrow.getBorrower().getSecondName()));
        }
        for(Vehicle vehicle : vehiclesAllCollection)
        {
            vehicleIfBorrowed.add(new VehicleIfBorrowed(vehicle.getId(),vehicle.getVehicleType(),
                            false,null,null,null));
        }
        return vehicleIfBorrowed;

    }


}
