package com.krol.shajs.repository;

import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Collection<Borrow> findByDate(LocalDate date);
    boolean existsByDateAndBorrowerAndVehicle(LocalDate date, Borrower borrower, Vehicle vehicle);
    boolean existsByDateAndVehicle(LocalDate date, Vehicle vehicle);

}
