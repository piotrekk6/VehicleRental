package com.krol.shajs.serviceImpl;

import com.krol.shajs.MockFactory;
import com.krol.shajs.dto.BorrowerDto;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.enums_converters.dtoConverter.BorrowerEntityDtoConverter;
import com.krol.shajs.exceptions.VehicleRentApplicationException;
import com.krol.shajs.repository.BorrowerRepository;
import com.krol.shajs.service.BorrowerService;
import com.krol.shajs.service.Implementation.BorrowerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BorrowerServiceTest {

    @MockBean
    private BorrowerRepository borrowerRepository;

    @MockBean
    private BorrowerEntityDtoConverter borrowerEntityDtoConverter;

    private BorrowerService borrowerService;

    @Before
    public void beforeMethod() {
        borrowerService = new BorrowerServiceImpl(borrowerRepository, borrowerEntityDtoConverter);
    }

    @Test
    public void testGetBorrowerById() throws VehicleRentApplicationException {
/*        //given
        Borrower borrower = MockFactory.getBorrowerMock();
        borrower.setId(1L);
        when(borrowerRepository.findById(1L)).thenReturn(borrower);
        //when
        Borrower borrowerById = borrowerService.getBorrowerById(1L);
        //then
        Assert.assertEquals(borrower, borrowerById);*/
    }

    @Test
    public void testAddBorrower() {
        //given: borrower mock
        Borrower borrower = MockFactory.getBorrowerMock();

        //and: borrowerDto mock
        BorrowerDto borrowerDto = MockFactory.getBorrowerDtoMock();

        //and: mock borrowerRepository and dto mapper
        when(borrowerEntityDtoConverter.createEntity(any(BorrowerDto.class))).thenReturn(borrower);
        //when: add new borrower
        borrowerService.addBorower(borrowerDto);

        //then: save new borrower
        ArgumentCaptor<Borrower> borrowerCaptor = ArgumentCaptor.forClass(Borrower.class);
        verify(borrowerRepository).save(borrowerCaptor.capture());

        Borrower borrower1 = borrowerCaptor.getValue();

        Assert.assertEquals(borrower.getFirstName(),borrower1.getFirstName());
        Assert.assertEquals(borrower.getSecondName(),borrower1.getSecondName());
        Assert.assertNotNull(borrower1.getId());
    }
}