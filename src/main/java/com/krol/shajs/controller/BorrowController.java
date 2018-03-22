package com.krol.shajs.controller;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.BorrowedVehicleDto;
import com.krol.shajs.dto.VehicleWithBorrowNameAndDateDto;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.service.BorrowService;
import com.krol.shajs.service.BorrowerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@ResponseStatus(OK)
public class BorrowController {

    private final BorrowService borrowService;
    private final BorrowerService borrowerService;

    @PostMapping(value = "/borrow")
    public Borrow borrowVehicle(@RequestBody BorrowDto borrowDto) throws NotFoundException {
        return borrowService.borrowVehicle(borrowDto);
    }

    @GetMapping(value = "/show/{date}")
    public List<VehicleWithBorrowNameAndDateDto> showBorrowForSpecifiedDay(@PathVariable("date") String date) throws NotFoundException {
        return borrowService.getBorrowedVehiclesForSpecifiedDate(date);
    }

    @GetMapping(value = "/showAllBorrows")
    public Collection<BorrowedVehicleDto> showAllBorrows() {
        return borrowService.getAllBorrows();
    }

    @PostMapping(value = "addBorrower")
    public void addBorrower(@RequestBody Borrower borrower) {
        borrowerService.addBorower(borrower);
    }

    @GetMapping(value = "/getBorrowers")
    public Collection<Borrower> getBorrowers() {
        return borrowerService.findAll(); //TODO return DTO as endpoint
    }

}
