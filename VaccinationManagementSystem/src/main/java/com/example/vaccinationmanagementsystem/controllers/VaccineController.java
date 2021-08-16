package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.representation.VaccineListRepresentation;
import com.example.vaccinationmanagementsystem.representation.VaccineRepresentation;
import com.example.vaccinationmanagementsystem.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vaccine")
public class VaccineController {
    private final VaccineService service;

    @Autowired
    public VaccineController(VaccineService service) {
        this.service = service;
    }

    @GetMapping("/")
    public VaccineListRepresentation retrieveAllVaccine() {
        return service.retrieveAllVaccines();
    }

    @GetMapping("/{id}")
    public VaccineRepresentation retrieveVaccineById(@PathVariable Long id) {
        return service.retrieveVaccineById(id);
    }

    @PostMapping("/createVaccine")
    public VaccineRepresentation createVaccine(@RequestBody VaccineRepresentation vaccineRepresentation) {
        return service.createVaccine(vaccineRepresentation);
    }

    @PutMapping("/updateVaccine/{id}")
    public VaccineRepresentation updateVaccine(@PathVariable Long id, @RequestBody VaccineRepresentation vaccineRepresentation) {
        return service.updateVaccine(id, vaccineRepresentation);
    }

    @PutMapping("/updateQuantityVaccine/{id}/{quantity}")
    public VaccineRepresentation updateVaccine(@PathVariable Long id, @PathVariable int quantity) {
        return service.updateQuantityVaccine(id, quantity);
    }

    @DeleteMapping("/deleteVaccine/{id}")
    public void deleteVaccine(@PathVariable Long id) {
        service.deleteVaccine(id);
    }

}
