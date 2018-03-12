package com.krol.shajs.controller;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.BorrowedVehicleDto;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.service.BorrowService;
import com.krol.shajs.service.BorrowerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class BorrowController {

    private final BorrowService borrowService;
    private final BorrowerService borrowerService;

    @PostMapping(value = "/borrow")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Borrow> borrowVehicle(@RequestBody BorrowDto borrowDto) throws NotFoundException {
        return ResponseEntity.ok(borrowService.borrowVehicle(borrowDto));
    }

    @GetMapping(value = "/show/{date}")
    @ResponseStatus(HttpStatus.OK)
    public Collection<BorrowedVehicleDto> showBorrowForSpecifiedDay(@PathVariable("date") String date) {
        return borrowService.getBorrowedVehiclesForSpecifiedDate(date);
    }

    @GetMapping(value = "/show")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Borrow> showAllBorrows() {
        return borrowService.getAllBorrows();
    }

    @PostMapping(value = "addBorrower")
    @ResponseStatus(HttpStatus.OK)
    public void addBorrower(@RequestBody Borrower borrower) {
        borrowerService.addBorower(borrower);
    }

    @GetMapping(value = "/getBorrowers")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Borrower> getBorrowers() {
        return borrowerService.findAll(); //TODO return DTO as endpoint
    }

}
