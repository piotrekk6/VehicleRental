package com.krol.shajs.Controller;

import com.krol.shajs.Dto.BorrowDto;
import com.krol.shajs.Entity.Borrow;
import com.krol.shajs.Entity.Borrower;
import com.krol.shajs.Exceptions.NotFoundException;
import com.krol.shajs.Service.BorrowService;
import com.krol.shajs.Service.BorrowerService;
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
