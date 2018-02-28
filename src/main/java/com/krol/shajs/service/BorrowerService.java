package com.krol.shajs.Service;

import com.krol.shajs.Entity.Borrow;
import com.krol.shajs.Entity.Borrower;
import com.krol.shajs.Exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;


public interface BorrowerService {

    Borrower getBorrowerById(Long id) throws NotFoundException;
    void addBorower(Borrower borrower);
}
