package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.service.VaccineAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assignment")
public class VaccineAssignment {

    private VaccineAssignmentService service;

    @Autowired
    public VaccineAssignment(VaccineAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public GeneralResponseStatus makeAssignment() {
        return service.makeAssigment();
    }
}
