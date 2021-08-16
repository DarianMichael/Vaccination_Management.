package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.representation.VaccineByGroupRepresentation;
import com.example.vaccinationmanagementsystem.service.VaccineByGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vaccineByGroup/")
public class VaccineAgeRangeController {

    private final VaccineByGroupService service;

    @Autowired
    public VaccineAgeRangeController(VaccineByGroupService service) {
        this.service = service;
    }

    @GetMapping
    public GeneralResponseStatus retrieveAll() {
        return service.retrieveAll();
    }

    @PostMapping
    public GeneralResponseStatus create(@RequestBody VaccineByGroupRepresentation vaccine) {
        return service.create(vaccine);
    }

    @DeleteMapping("/{vaccineId}/{ageRangeId}")
    public GeneralResponseStatus delete(@PathVariable Long vaccineId, @PathVariable Long ageRangeId) {
        return service.delete(vaccineId, ageRangeId);
    }
}
