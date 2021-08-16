package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.representation.ParamRepresentation;
import com.example.vaccinationmanagementsystem.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parameter/")
public class ParameterController {

    private ParameterService service;

    @Autowired
    public ParameterController(ParameterService service) {
        this.service = service;
    }

    @GetMapping
    public GeneralResponseStatus retrieveAll() {
        return service.retrieveAll();
    }

    @PutMapping("/{id}")
    public GeneralResponseStatus update(@PathVariable Long id, @RequestBody ParamRepresentation param) {
        return service.update(id, param);
    }

    @PostMapping
    public GeneralResponseStatus create(@RequestBody ParamRepresentation param) {
        return service.create(param);
    }

    @DeleteMapping("/{id}")
    public GeneralResponseStatus delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
