package com.krol.shajs.service;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.BorrowedVehicleDto;
import com.krol.shajs.dto.VehicleWithBorrowNameAndDateDto;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.exceptions.ApplicationException;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

public interface BorrowService {
    Borrow borrowVehicle(BorrowDto borrowDto) throws ApplicationException;
    List<VehicleWithBorrowNameAndDateDto> getAllVehiclesWithBorrowInfoForSpecifiedDate(String date) throws ApplicationException, ParseException;
    Collection<BorrowedVehicleDto> getAllBorrows();

}