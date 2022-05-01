package com.r2.spiral.adapters;

import com.r2.spiral.adapters.output.ErrorResponse;
import com.r2.spiral.adapters.request.validations.RequestValidationException;
import com.r2.spiral.configuration.Instrumentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(RequestValidationException.class)
    protected ResponseEntity handleContentNotAllowedException(RequestValidationException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
