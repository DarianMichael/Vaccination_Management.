package com.example.vaccinationmanagementsystem.service;

import com.example.vaccinationmanagementsystem.exception.VaccineEntityNotFoundException;
import com.example.vaccinationmanagementsystem.models.DiseasePriority;
import com.example.vaccinationmanagementsystem.repository.AgeRangeRepository;
import com.example.vaccinationmanagementsystem.repository.DiseasePriorityRepository;
import com.example.vaccinationmanagementsystem.representation.DiseasePriorityListRepresentation;
import com.example.vaccinationmanagementsystem.representation.DiseasePriorityRepresentation;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DiseasePriorityService {

    private DiseasePriorityRepository repository;
    private AgeRangeRepository ageRangeRepository;

    @Autowired
    public DiseasePriorityService(DiseasePriorityRepository repository) {
        this.repository = repository;
        AgeRangeRepository ageRangeRepository;
    }

    public GeneralResponseStatus retrieveAll() {
        GeneralResponseStatus generalResponseStatus = new GeneralResponseStatus();
        generalResponseStatus.setData(new DiseasePriorityListRepresentation(repository.findAll().stream()
                .map(DiseasePriority::toRepresentation)
                .collect(Collectors.toList())));
        return generalResponseStatus;
    }

    public GeneralResponseStatus update(Long id, DiseasePriorityRepresentation diseasePriority) {
        return new GeneralResponseStatus(repository.findById(id).map(savedDiseasePriority -> {
            savedDiseasePriority.setValue(diseasePriority.getValue());
            savedDiseasePriority.setDisease(diseasePriority.getDisease());
            return repository.save(savedDiseasePriority).toRepresentation();
        }).orElseThrow(() -> new VaccineEntityNotFoundException("AgePriority not found with id:" + id)));
    }

    public GeneralResponseStatus create(DiseasePriorityRepresentation diseasePriority) {
        return new GeneralResponseStatus(repository.save(diseasePriority.toEntity()));
    }

    public GeneralResponseStatus delete(Long id) {
        repository.deleteById(id);
        return new GeneralResponseStatus();
    }
}
