package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.exception.DuplicatedPersonException;
import com.example.vaccinationmanagementsystem.exception.VaccineEntityNotFoundException;
import com.example.vaccinationmanagementsystem.representation.ErrorResponse;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public GeneralResponseStatus handleValidationErrors(MethodArgumentNotValidException e) {
        return new GeneralResponseStatus(new ErrorResponse(e.getMessage(), ""));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    private GeneralResponseStatus handleDuplicatedPerson(DuplicatedPersonException e) {
        return new GeneralResponseStatus(new ErrorResponse(e.getMessage(), ""));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    private GeneralResponseStatus handleEntityNotFound(VaccineEntityNotFoundException e) {
        return new GeneralResponseStatus(new ErrorResponse(e.getMessage(), ""));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    private GeneralResponseStatus handleGenericError(Exception e) {
        return new GeneralResponseStatus(new ErrorResponse(e.getMessage(), ""));
    }


}
