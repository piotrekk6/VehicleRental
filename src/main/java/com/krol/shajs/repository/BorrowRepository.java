package com.krol.shajs.repository;

import com.krol.shajs.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Collection<Borrow> findByDate(LocalDate date);
}
