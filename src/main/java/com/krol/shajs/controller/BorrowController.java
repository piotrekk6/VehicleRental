package com.krol.shajs.controller;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.VehicleIfBorrowed;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.service.BorrowService;
import com.krol.shajs.service.BorrowerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class BorrowController {

    private final BorrowService borrowService;
    private final BorrowerService borrowerService;

    @PostMapping(value = "/borrow")
    @ResponseStatus(HttpStatus.OK)
    public Borrow borrowVehicle(@RequestBody BorrowDto borrowDto) throws NotFoundException {
        return borrowService.borrowVehicle(borrowDto);
    }

    @GetMapping(value = "/show/{date}")
    @ResponseStatus(HttpStatus.OK)
    public Collection<VehicleIfBorrowed> showBorrowForSpecifiedDay(@PathVariable("date") String date) {
        return borrowService.getBorrowedVehiclesForSpecifiedDate(date);
    }

    @PostMapping(value = "addBorrower")
    public void addBorrower(@RequestBody Borrower borrower) {
        borrowerService.addBorower(borrower);
    }

}
