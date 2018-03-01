package com.krol.shajs.service;

import com.krol.shajs.entity.Borrower;
import com.krol.shajs.exceptions.NotFoundException;


public interface BorrowerService {

    Borrower getBorrowerById(Long id) throws NotFoundException;
    void addBorower(Borrower borrower);
}
