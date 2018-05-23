package com.krol.shajs.enums_converters;

import lombok.*;

@AllArgsConstructor
@Getter
public enum ExceptionCode {
    BORROWER_NOT_FOUND("Borrower with specified id doesn't exist"),
    VEHICLE_NOT_FOUND("Vehicle  with specified id doesn't exist"),
    BORROW_NOT_FOUND("Borrow doesn't exist"),
    VEHICLE_ALREADY_BORROWED("Vehicle is already borrowed for this date"),
    WRONG_DATE("Invalid date"),
    MANUFACTURER_NOT_FOUND("Manufacturer not found"),
    USER_NOT_FOUND("User not found"),
    USER_ALREADY_EXISTS("User with this name already exist. Try another username");

    private  String code;
}
