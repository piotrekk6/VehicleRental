package com.krol.shajs.service;

import com.krol.shajs.dto.BorrowerDto;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.exceptions.ApplicationException;

import java.util.List;


public interface BorrowerService {

    Borrower getBorrowerById(Long id) throws ApplicationException;
    void addBorower(BorrowerDto borrowerDto);
    List<BorrowerDto> findAll();
}
