package com.krol.shajs.ServiceTest;

import com.krol.shajs.entity.Borrower;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.BorrowerRepository;
import com.krol.shajs.service.BorrowerService;
import com.krol.shajs.service.Implementation.BorrowerServiceImpl;
import com.sun.org.apache.xpath.internal.Arg;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BorrowerServiceTest {

    @MockBean
    private BorrowerRepository borrowerRepository;

    private BorrowerService borrowerService;

    @Before
    public void beforeMethod() {
        borrowerService = new BorrowerServiceImpl(borrowerRepository);
    }

    @Test
    public void testGetBorrowerById() throws NotFoundException {
        //given
        Borrower borrower = new Borrower();
        when(borrowerRepository.findOne(1L)).thenReturn(borrower);
        //when
        Borrower borrowerById = borrowerService.getBorrowerById(1L);
        //then
        Assert.assertEquals(borrower, borrowerById);
    }

    @Test
    public void testFindAll() {
        //given
        List<Borrower> borrowerList = new ArrayList<>();
        when(borrowerRepository.findAll()).thenReturn(borrowerList);
        //when
        Assert.assertEquals(borrowerList, borrowerService.findAll());
        //then
    }

    @Test
    public void testAddBorrower() {

        //given
        Borrower borrower = new Borrower();
        borrower.setId(98L);
        borrower.setFirstName("Jan");
        borrower.setSecondName("Kowalski");
        when(borrowerRepository.save(borrower)).thenReturn(borrower);

        //when
        borrowerService.addBorower(borrower);

        //then
        ArgumentCaptor<Borrower> borrowerCaptor = ArgumentCaptor.forClass(Borrower.class);
        verify(borrowerRepository).save(borrowerCaptor.capture());

        Borrower borrower1 = borrowerCaptor.getValue();

        Assert.assertEquals(borrower.getFirstName(),borrower1.getFirstName());
        Assert.assertEquals(borrower.getSecondName(),borrower1.getSecondName());
        Assert.assertEquals(borrower.getId(), borrower1.getId());
    }

}
