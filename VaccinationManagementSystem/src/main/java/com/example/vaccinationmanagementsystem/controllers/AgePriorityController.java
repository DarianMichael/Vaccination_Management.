package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.models.AgePriority;
import com.example.vaccinationmanagementsystem.representation.AgePriorityRepresentation;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.service.AgePriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agePriority/")
public class AgePriorityController {

    private AgePriorityService service;

    @Autowired
    public AgePriorityController(AgePriorityService service) {
        this.service = service;
    }

    @GetMapping
    public GeneralResponseStatus retrieveAll() {
        return service.retrieveAll();
    }

    @PutMapping("/{id}")
    public GeneralResponseStatus update(@PathVariable Long id, @RequestBody AgePriorityRepresentation agePriority) {
        return service.update(id, agePriority);
    }

    @PostMapping
    public GeneralResponseStatus create(@RequestBody AgePriorityRepresentation agePriority) {
        return service.create(agePriority);
    }

    @DeleteMapping("/{id}")
    public GeneralResponseStatus delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
