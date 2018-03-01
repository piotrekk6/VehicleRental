package com.krol.shajs.utility;

package com.rental.carshowroom.handler;

import com.rental.carshowroom.exception.NotFoundException;
import com.rental.carshowroom.util.ConstraintsUtil;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@PropertySource("classpath:validationmessages.properties")
@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    private Environment env;

    @Autowired
    public GlobalExceptionHandler(Environment env) {
        this.env = env;
    }

    @Value("${msg.validation.json.syntax.wrong}")
    private String wrongJsonSyntaxError;

    @Value("${msg.validation.wrongparameters}")
    private String wrongParametersError;

    private String errorKey = "error";

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return Collections.singletonMap(errorKey, wrongJsonSyntaxError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> response = new LinkedHashMap<>();
        BindingResult errors = e.getBindingResult();
        for (FieldError fieldError : errors.getFieldErrors()) {
            response.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return response;
    }

    @ExceptionHandler({IllegalStateException.class, MappingException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleIllegalStateOrArgumentOrMappingException(Exception e) {
        return Collections.singletonMap(errorKey, wrongJsonSyntaxError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleDataIntegrityViolationException(Exception e) {
        return Collections.singletonMap(ConstraintsUtil.getConstraintNameFromException(e.getCause().getCause()), ConstraintsUtil.getConstraintMessageFromException(e.getCause().getCause()));
    }

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleTypeMismatchException(TypeMismatchException e) {
        return Collections.singletonMap(errorKey, wrongParametersError);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Map<String, String> handleNotFoundException(NotFoundException e) {
        return Collections.singletonMap(errorKey, env.getProperty(e.getCode().getDescriptionProperty()));
    }
}
