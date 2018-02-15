package com.krol.shajs.Exceptions;

import com.krol.shajs.Enum.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotFoundException  extends  Exception{
    private ExceptionCode code;
}
