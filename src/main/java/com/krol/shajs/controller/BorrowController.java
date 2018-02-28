package com.krol.shajs.controller;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.service.BorrowService;
import com.krol.shajs.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api")
public class BorrowController {

    @Autowired
    BorrowService borrowService;

    @Autowired
    BorrowerService borrowerService;

    @PostMapping(value = "/borrow")
    public ResponseEntity<Borrow> borrowVehicle(@RequestBody BorrowDto borrowDto) throws NotFoundException {
     return ResponseEntity.ok(borrowService.borrowVehicle(borrowDto));
    }

    @GetMapping(value = "/show/{date}")
    public ResponseEntity<Collection> showBorrowForSpecifiedDay(@PathVariable("date") String date)
    {
        LocalDate localDate = LocalDate.parse(date);
        return ResponseEntity.ok(borrowService.getBorrowedVehiclesForSpecifiedDate(localDate));
    }

    @PostMapping(value = "addBorrower")
    public void  addBorrower(@RequestBody Borrower borrower)
    {
        borrowerService.addBorower(borrower);
    }

}
