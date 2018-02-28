package com.krol.shajs.Service;

import com.krol.shajs.Dto.BorrowDto;
import com.krol.shajs.Dto.VehicleIfBorrowed;
import com.krol.shajs.Entity.Borrow;
import com.krol.shajs.Exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.Collection;

public interface BorrowService {
    Borrow borrowVehicle(BorrowDto borrowDto) throws NotFoundException;
    Collection<VehicleIfBorrowed> getBorrowedVehiclesForSpecifiedDate(LocalDate date);

}