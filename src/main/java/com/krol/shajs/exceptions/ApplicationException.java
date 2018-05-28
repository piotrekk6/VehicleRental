package com.krol.shajs.exceptions;

import com.krol.shajs.enums_converters.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApplicationException extends  Exception{
    private ExceptionCode code;
}