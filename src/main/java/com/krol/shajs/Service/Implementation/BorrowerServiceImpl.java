package com.krol.shajs.Service.Implementation;

import com.krol.shajs.Entity.Borrower;
import com.krol.shajs.Enum.ExceptionCode;
import com.krol.shajs.Exceptions.NotFoundException;
import com.krol.shajs.Repository.BorrowerRepository;
import com.krol.shajs.Service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public Borrower getBorrowerById(Long id) throws NotFoundException {
        Borrower borrower = borrowerRepository.findOne(id);
        if (borrower == null) throw new NotFoundException(ExceptionCode.BORROWER_NOT_FOUND);
        else return borrower;
    }

    @Override
    public void addBorower(Borrower borrower) {
        borrowerRepository.save(borrower);
    }
}
