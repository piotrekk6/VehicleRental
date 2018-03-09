package com.krol.shajs.service.Implementation;

import com.krol.shajs.entity.Borrower;
import com.krol.shajs.enums_converters.ExceptionCode;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.BorrowerRepository;
import com.krol.shajs.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }
}
