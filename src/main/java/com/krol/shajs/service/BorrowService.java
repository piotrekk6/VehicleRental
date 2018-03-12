package com.krol.shajs.service;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.BorrowedVehicleDto;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.exceptions.NotFoundException;

import java.util.Collection;

public interface BorrowService {
    Borrow borrowVehicle(BorrowDto borrowDto) throws NotFoundException;
    Collection<BorrowedVehicleDto> getBorrowedVehiclesForSpecifiedDate(String date);
    Collection<Borrow> getAllBorrows();

}