package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.representation.CitizenRepresentation;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/citizen")
public class CitizenController {

    private SignUpService service;

    @Autowired
    public CitizenController(SignUpService service) {
        this.service = service;
    }

    @PostMapping("/sign-up")
    public GeneralResponseStatus signUp(@Valid() @RequestBody CitizenRepresentation citizenRepresentation) {
        return service.singUp(citizenRepresentation);
    }
}
