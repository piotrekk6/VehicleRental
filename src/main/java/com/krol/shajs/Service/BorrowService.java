package com.krol.shajs.Service;

import com.krol.shajs.Dto.BorrowDto;
import com.krol.shajs.Entity.Borrow;
import com.krol.shajs.Exceptions.NotFoundException;

public interface BorrowService {
    Borrow borrowVehicle(BorrowDto borrowDto) throws NotFoundException;
}