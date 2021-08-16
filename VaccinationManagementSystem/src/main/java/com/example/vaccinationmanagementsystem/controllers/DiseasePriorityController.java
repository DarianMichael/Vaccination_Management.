package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.models.DiseasePriority;
import com.example.vaccinationmanagementsystem.representation.DiseasePriorityRepresentation;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.service.DiseasePriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diseasePriority/")
public class DiseasePriorityController {

    private DiseasePriorityService service;

    @Autowired
    public DiseasePriorityController(DiseasePriorityService service) {
        this.service = service;
    }

    @GetMapping
    public GeneralResponseStatus retrieveAll() {
        return service.retrieveAll();
    }

    @PutMapping("/{id}")
    public GeneralResponseStatus update(@PathVariable Long id, @RequestBody DiseasePriorityRepresentation diseasePriority) {
        return service.update(id, diseasePriority);
    }

    @PostMapping
    public GeneralResponseStatus create(@RequestBody DiseasePriorityRepresentation diseasePriority) {
        return service.create(diseasePriority);
    }

    @DeleteMapping("/{id}")
    public GeneralResponseStatus delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
