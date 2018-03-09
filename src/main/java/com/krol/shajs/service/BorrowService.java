package com.krol.shajs.service;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.VehicleIfBorrowed;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.Collection;

public interface BorrowService {
    Borrow borrowVehicle(BorrowDto borrowDto) throws NotFoundException;
    Collection<VehicleIfBorrowed> getBorrowedVehiclesForSpecifiedDate(String date);
    Collection<Borrow> getAllBorrows();

}