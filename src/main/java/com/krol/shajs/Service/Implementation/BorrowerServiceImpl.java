package com.krol.shajs.Service.Implementation;

import com.krol.shajs.Entity.Borrower;
import com.krol.shajs.Repository.BorrowerRepository;
import com.krol.shajs.Service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public Borrower getBorrowerById(Long id) {
        return borrowerRepository.findOne(id);
    }//TODO record with specified id doesnt exist
}
