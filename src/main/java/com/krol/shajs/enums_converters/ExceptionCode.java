package com.krol.shajs.enums_converters;

import lombok.*;

@AllArgsConstructor
@Getter
public enum ExceptionCode {
    BORROWER_NOT_FOUND("Borrower with specified id doesn't exist"),
    VEHICLE_NOT_FOUND("Vehicle  with specified id doesn't exist");


    private  String code;
}
