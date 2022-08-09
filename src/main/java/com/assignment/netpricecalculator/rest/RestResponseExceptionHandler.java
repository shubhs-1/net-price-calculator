package com.assignment.netpricecalculator.rest;

import com.assignment.netpricecalculator.exception.DataNotFoundException;
import com.assignment.netpricecalculator.exception.InvalidParameterPassedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFoundException(final DataNotFoundException exception,
                                                              final HttpServletRequest request) {
        RestResponse dataNotFoundResponse = RestResponse.builder().message("No data found").status("failure").build();
        return new ResponseEntity<>(dataNotFoundResponse, HttpStatus.OK);
    }

    @ExceptionHandler(InvalidParameterPassedException.class)
    public ResponseEntity<Object> handleInvalidParameterPassedException(final InvalidParameterPassedException exception,
                                                              final HttpServletRequest request) {
        RestResponse invalidParametersResponse = RestResponse.builder().message("Invalid parameters passed").status("failure").build();
        return new ResponseEntity<>(invalidParametersResponse, HttpStatus.BAD_REQUEST);
    }
}
