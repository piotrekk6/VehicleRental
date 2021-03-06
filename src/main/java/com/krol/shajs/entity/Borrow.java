package com.krol.shajs.entity;

import com.krol.shajs.enums_converters.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = DateConverter.class)
    @NotNull
    private LocalDate date;
    
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Borrower borrower;

    public void borrow(Borrower borrower, Vehicle vehicle, LocalDate date)
    {
        this.setBorrower(borrower);
        this.setVehicle(vehicle);
        this.setDate(date);
    }
}
