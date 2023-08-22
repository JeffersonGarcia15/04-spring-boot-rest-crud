package com.jefferson.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // global exception handling
public class StudentRestExceptionHandler {

    // add exception handling code here
    @ExceptionHandler // when an exception is thrown, this method will be called
    // ResponseEntity<StudentErrorResponse> is the type of response body
    // StudentErrorResponse is the Exception type we are going to catch
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        // set the status using the setter
        error.setStatus(HttpStatus.NOT_FOUND.value());
        // set the message using the setter
        error.setMessage(exc.getMessage());
        // set the timestamp using the setter
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity. body, status
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler to catch any exception(catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        // set the status using the setter
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        // set the message using the setter
        error.setMessage(exc.getMessage());
        // set the timestamp using the setter
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity. body, status
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
