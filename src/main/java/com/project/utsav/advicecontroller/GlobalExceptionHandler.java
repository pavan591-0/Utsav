package com.project.utsav.advicecontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.utsav.exceptions.EventException;
import com.project.utsav.exceptions.RegistrationException;
import com.project.utsav.exceptions.UserException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EventException.class)
    public ResponseEntity<String> handleEventException(EventException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage()); 
    }
    
    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleUserException(UserException ux) {
        return ResponseEntity
                .badRequest()
                .body(ux.getMessage()); 
    }
    
    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<String> handleRegistrationException(RegistrationException rx){
    	return ResponseEntity
    			.badRequest()
    			.body(rx.getMessage());
    }
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }
}

