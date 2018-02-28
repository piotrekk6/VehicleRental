package com.krol.shajs.Repository;

import com.krol.shajs.Entity.Borrow;
import com.krol.shajs.Entity.Vehicle;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Collection<Borrow> findByDate(LocalDate date);
}
