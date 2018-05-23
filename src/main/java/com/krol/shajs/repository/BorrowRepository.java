package com.krol.shajs.repository;

import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Collection<Borrow> findByDate(LocalDate date);

    boolean existsByDateAndVehicle(LocalDate date, Vehicle vehicle);

    Borrow findByDateAndVehicle(LocalDate date, Vehicle v);

    @Query(value = "select * from vehicle v left join borrow b on b.vehicle_id = v.id and b.date = :date", nativeQuery = true)
    List<Borrow> getBorrowInfo(@Param("date") Date date);


}
