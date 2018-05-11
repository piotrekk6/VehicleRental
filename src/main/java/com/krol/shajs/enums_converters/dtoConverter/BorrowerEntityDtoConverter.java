package com.krol.shajs.enums_converters.dtoConverter;

import com.krol.shajs.dto.BorrowerDto;
import com.krol.shajs.entity.Borrower;
import org.springframework.stereotype.Component;

@Component
public class BorrowerEntityDtoConverter {

    public Borrower createEntity(BorrowerDto borrowerDto)
    {
        Borrower borrower = new Borrower();
        borrower.setFirstName(borrowerDto.getFirstName());
        borrower.setSecondName(borrowerDto.getSecondName());
        return borrower;
    }

    public BorrowerDto borrowerDto(Borrower borrower)
    {
        BorrowerDto borrowerDto = new BorrowerDto();
        borrowerDto.setFirstName(borrower.getFirstName());
        borrowerDto.setSecondName(borrower.getSecondName());
        borrowerDto.setId(borrower.getId());
        return borrowerDto;
    }
}
