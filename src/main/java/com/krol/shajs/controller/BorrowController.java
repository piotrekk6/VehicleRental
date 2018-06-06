package com.krol.shajs.controller;

import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.dto.BorrowedVehicleDto;
import com.krol.shajs.dto.BorrowerDto;
import com.krol.shajs.dto.VehicleWithBorrowNameAndDateDto;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.exceptions.VehicleRentApplicationException;
import com.krol.shajs.service.BorrowService;
import com.krol.shajs.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/borrow")
@RequiredArgsConstructor
@ResponseStatus(OK)
public class BorrowController {

    private final BorrowService borrowService;
    private final BorrowerService borrowerService;

    @PostMapping
    public Borrow borrowVehicle(@RequestBody BorrowDto borrowDto) throws VehicleRentApplicationException {
        return borrowService.borrowVehicle(borrowDto);
    }

    @GetMapping(value = "/{date}")
    public List<VehicleWithBorrowNameAndDateDto> showBorrowForSpecifiedDay(@PathVariable("date") String date) throws VehicleRentApplicationException, ParseException {
        return borrowService.getBorrowedVehiclesForSpecifiedDate(date);
    }

    @GetMapping
    public Collection<BorrowedVehicleDto> showAllBorrows() {
        return borrowService.getAllBorrows();
    }

    @PostMapping("/people")
    public void addBorrower(@RequestBody BorrowerDto borrowerDto) {
        borrowerService.addBorower(borrowerDto);
    }

    @GetMapping(value = "/people")
    public Collection<BorrowerDto> getBorrowers() {
        return borrowerService.findAll();
    }

}
