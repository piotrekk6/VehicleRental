package com.krol.shajs.Entity;

import com.krol.shajs.Enum.DateConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = DateConverter.class)
    private LocalDate dateFrom;

    @Convert(converter = DateConverter.class)
    private LocalDate dateTo;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Borrower borrower;


    public void borrow(Borrower borrower, Vehicle vehicle)
    {
        this.setBorrower(borrower);
        this.setVehicle(vehicle);
    }

}
