package com.krol.shajs.Exceptions.Handler;

import com.krol.shajs.Exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Component
@ControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    protected Map<String,String> handleNotFoundException(NotFoundException e)
    {
        return Collections.singletonMap("Error", e.getCode().getCode());

    }
}
