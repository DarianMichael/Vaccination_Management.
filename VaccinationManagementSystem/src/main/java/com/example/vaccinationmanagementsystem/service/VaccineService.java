package com.example.vaccinationmanagementsystem.service;

import com.example.vaccinationmanagementsystem.models.Vaccine;
import com.example.vaccinationmanagementsystem.repository.VaccineRepository;
import com.example.vaccinationmanagementsystem.representation.VaccineListRepresentation;
import com.example.vaccinationmanagementsystem.representation.VaccineRepresentation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VaccineService {


    private final VaccineRepository repository;

    @Autowired
    public VaccineService(VaccineRepository repository) {
        this.repository = repository;
    }

    public VaccineListRepresentation retrieveAllVaccines() {
        return new VaccineListRepresentation(repository.findAll().stream()
                .map(Vaccine::toRepresentation).collect(Collectors.toList()));
    }

    public VaccineRepresentation retrieveVaccineById(Long id) {
        return repository.findById(id).map(Vaccine::toRepresentation).orElse(null);
    }

    public VaccineRepresentation createVaccine(VaccineRepresentation vaccineRepresentation) {
        return repository.save(vaccineRepresentation.toEntity()).toRepresentation();
    }

    public VaccineRepresentation updateVaccine(Long id, VaccineRepresentation vaccineRepresentation) {
        Optional<Vaccine> vaccine = repository.findById(id);
        if (vaccine.isPresent()) {
            Vaccine updatedVaccine = vaccine.get();
            updatedVaccine.setName(vaccineRepresentation.getName());
            updatedVaccine.setQuantity(vaccineRepresentation.getQuantity());
            return repository.save(updatedVaccine).toRepresentation();
        }
        log.error("Entity no found with id {}", id);
        return null;
    }

    public VaccineRepresentation updateQuantityVaccine(Long id, int quantity) {
        Optional<Vaccine> vaccine = repository.findById(id);
        if (vaccine.isPresent()) {
            Vaccine updatedVaccine = vaccine.get();
            updatedVaccine.setQuantity(quantity);
            return repository.save(updatedVaccine).toRepresentation();
        }
        log.error("Entity no found with id {}", id);
        return null;
    }

    public void deleteVaccine(Long id) {
        repository.deleteById(id);
    }


}
