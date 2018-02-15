package com.krol.shajs.Service;

import com.krol.shajs.Entity.Borrower;
import org.springframework.stereotype.Service;


public interface BorrowerService {

    Borrower getBorrowerById(Long id);
}
