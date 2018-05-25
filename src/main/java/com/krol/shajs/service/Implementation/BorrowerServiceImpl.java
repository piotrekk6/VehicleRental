package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.BorrowerDto;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.enums_converters.dtoConverter.BorrowerEntityDtoConverter;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.BorrowerRepository;
import com.krol.shajs.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.krol.shajs.enums_converters.ExceptionCode.BORROWER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepository;
    private final BorrowerEntityDtoConverter borrowerEntityDtoConverter;

    @Override
    public Borrower getBorrowerById(Long id) throws NotFoundException {
        Borrower borrower = borrowerRepository.findOne(id);
        if (borrower == null) throw new NotFoundException(BORROWER_NOT_FOUND);
        else return borrower;
    }

    @Override
    public void addBorower(BorrowerDto borrowerDto) {
        Borrower borrower = borrowerEntityDtoConverter.createEntity(borrowerDto);
        borrowerRepository.save(borrower);
    }

    @Override
    public List<BorrowerDto> findAll() {
        return borrowerRepository.findAll()
                                 .stream()
                                 .map(borrowerEntityDtoConverter::borrowerDto)
                                 .collect(Collectors.toList());
    }
}
