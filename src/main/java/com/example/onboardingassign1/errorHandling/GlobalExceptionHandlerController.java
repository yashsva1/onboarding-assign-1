package com.example.onboardingassign1.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request){
        Error error=new Error();
        error.setMessage(ex.getMessage());
        error.setTimestamp(new Date().getTime());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,null,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> badRequest(MethodArgumentNotValidException ex,HttpServletRequest request){
        final StringBuffer errors = new StringBuffer();
        for(FieldError fieldError: ex.getBindingResult().getFieldErrors()){
            errors.append(fieldError.getField()+" : "+fieldError.getDefaultMessage());
            errors.append(" | ");
        }
        Error error=new Error();
        error.setMessage(errors.toString());
        error.setTimestamp(new Date().getTime());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error,null,HttpStatus.BAD_REQUEST);

    }
}
