package com.krol.shajs.Controller;

import com.krol.shajs.Dto.BorrowDto;
import com.krol.shajs.Entity.Borrow;
import com.krol.shajs.Service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowController {

    @Autowired
    BorrowService borrowService;

    @PostMapping(value = "/borrow")
    public ResponseEntity<Borrow> borrowVehicle(@RequestBody BorrowDto borrowDto)
    {
     return ResponseEntity.ok(borrowService.borrowVehicle(borrowDto));
    }

}
