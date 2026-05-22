package com.workintech.s18d1.exceptions;

import com.workintech.s18d1.exceptions.BurgerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class) // Hatanın yakalanması için bu şart
    public ResponseEntity<BurgerErrorResponse> handleRuntimeException(RuntimeException ex) {
        BurgerErrorResponse response = new BurgerErrorResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}