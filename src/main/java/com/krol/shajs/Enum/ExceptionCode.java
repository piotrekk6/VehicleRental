package com.krol.shajs.Enum;

import lombok.*;

@AllArgsConstructor
@Getter
public enum ExceptionCode {
    BORROWER_NOT_FOUND("Borrower with specified id doesn't exist"),
    VEHICLE_NOT_FOUND("Vehicle  with specified id doesn't exist");


    private  String code;
}
