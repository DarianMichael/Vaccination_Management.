package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.representation.AgeRangeRepresentation;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.service.AgeRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ageRange")
public class AgeRangeController {

    private AgeRangeService service;

    @Autowired
    public AgeRangeController(AgeRangeService service) {
        this.service = service;
    }

    @GetMapping
    public GeneralResponseStatus retrieveAll() {
        return service.retrieveAll();
    }

    @PutMapping("/{id}")
    public GeneralResponseStatus update(@PathVariable Long id, @RequestBody AgeRangeRepresentation ageRange) {
        return service.update(id, ageRange);
    }

    @PostMapping
    public GeneralResponseStatus create(@RequestBody AgeRangeRepresentation ageRange) {
        return service.create(ageRange);
    }

    @DeleteMapping("/{id}")
    public GeneralResponseStatus delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
