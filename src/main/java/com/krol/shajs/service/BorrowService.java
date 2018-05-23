package com.krol.shajs.service;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.BorrowedVehicleDto;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.exceptions.NotFoundException;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

public interface BorrowService {
    Borrow borrowVehicle(BorrowDto borrowDto) throws NotFoundException;
    List<Borrow> getAllVehiclesWithBorrowInfoForSpecifiedDate(String date) throws NotFoundException, ParseException;
    Collection<BorrowedVehicleDto> getAllBorrows();

}