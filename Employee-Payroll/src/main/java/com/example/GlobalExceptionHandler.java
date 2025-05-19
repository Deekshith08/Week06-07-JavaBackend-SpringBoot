package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorClass> handleValidationException(MethodArgumentNotValidException ex){
        String errMsg = ex.getBindingResult().getFieldErrors().stream().
                map(fieldError -> fieldError.getField() +": "+fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorClass error = new ErrorClass(LocalDateTime.now(), HttpStatus.BAD_GATEWAY.value(), errMsg);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
