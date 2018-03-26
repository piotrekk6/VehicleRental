package com.krol.shajs.service.Implementation;

import com.krol.shajs.dto.*;
import com.krol.shajs.dto.BorrowDto;
import com.krol.shajs.entity.Borrow;
import com.krol.shajs.entity.Borrower;
import com.krol.shajs.entity.Vehicle;
import com.krol.shajs.enums_converters.dtoConverter.BorrowEntityDtoConverter;
import com.krol.shajs.exceptions.NotFoundException;
import com.krol.shajs.repository.BorrowRepository;
import com.krol.shajs.service.BorrowService;
import com.krol.shajs.service.BorrowerService;
import com.krol.shajs.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.krol.shajs.enums_converters.ExceptionCode.VEHICLE_ALREADY_BORROWED;

@Service
@Transactional
@RequiredArgsConstructor
public class BorrowServiceImpl extends BikeCarModelMapper implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final BorrowerService borrowerService;
    private final VehicleService vehicleService;
    private final BorrowEntityDtoConverter borrowEntityDtoConverter;

    @Override
    public Borrow borrowVehicle(BorrowDto borrowDto) throws NotFoundException {
        Borrower borrower = borrowerService.getBorrowerById(borrowDto.getBorrowerId());
        Vehicle vehicle = vehicleService.getVehicleByID(borrowDto.getVehicleId());
        boolean existsByDateAndVehicle = borrowRepository.existsByDateAndVehicle(borrowDto.getDate(), vehicle);
        if (!existsByDateAndVehicle) {
            Borrow borrow = new Borrow();
            borrow.borrow(borrower, vehicle, borrowDto.getDate());
            return borrowRepository.save(borrow);
        } else throw new NotFoundException(VEHICLE_ALREADY_BORROWED);
    }

    @Override
    public List<VehicleWithBorrowNameAndDateDto> getBorrowedVehiclesForSpecifiedDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Vehicle> allVehicles = vehicleService.getAll();
        List<VehicleWithBorrowNameAndDateDto> list = new ArrayList<>();

        for (Vehicle vehicle : allVehicles) {
            Borrow b = borrowRepository.findByDateAndVehicle(localDate, vehicle);
            VehicleWithBorrowNameAndDateDto v = vehicleEntityToFlatDto(vehicle);
            if (b != null) {
                v.setBorrowDate(b.getDate());
                v.setBorrowerFirstName(b.getBorrower().getFirstName());
                v.setBorrowerSecondName(b.getBorrower().getSecondName());
            }
            list.add(v);
        }
        return list;
    }

    @Override
    public Collection<BorrowedVehicleDto> getAllBorrows() {
        return borrowRepository.findAll().stream()
                               .map(borrowEntityDtoConverter::createDto)
                               .collect(Collectors.toList());
    }
}
