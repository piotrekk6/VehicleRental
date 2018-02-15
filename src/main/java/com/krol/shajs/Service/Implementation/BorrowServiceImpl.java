package com.krol.shajs.Service.Implementation;

import com.krol.shajs.Dto.BorrowDto;
import com.krol.shajs.Entity.Borrow;
import com.krol.shajs.Entity.Borrower;
import com.krol.shajs.Entity.Vehicle;
import com.krol.shajs.Repository.BorrowRepository;
import com.krol.shajs.Service.BorrowService;
import com.krol.shajs.Service.BorrowerService;
import com.krol.shajs.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Borrow borrowVehicle(BorrowDto borrowDto){
        Borrower borrower = borrowerService.getBorrowerById(borrowDto.getBorrowerId());
        Vehicle vehicle = vehicleService.getVehicleByID(borrowDto.getVehicleId());
            Borrow borrow = new Borrow();
            borrow.setVehicle(vehicle);
            borrow.setBorrower(borrower);
            borrow.setDateFrom(borrowDto.getDateFrom());
            return borrowRepository.save(borrow);
    }
}
