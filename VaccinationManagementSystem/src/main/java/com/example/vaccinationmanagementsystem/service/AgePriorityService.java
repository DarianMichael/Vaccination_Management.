package com.example.vaccinationmanagementsystem.service;

import com.example.vaccinationmanagementsystem.exception.VaccineEntityNotFoundException;
import com.example.vaccinationmanagementsystem.models.AgePriority;
import com.example.vaccinationmanagementsystem.repository.AgePriorityRepository;
import com.example.vaccinationmanagementsystem.repository.AgeRangeRepository;
import com.example.vaccinationmanagementsystem.representation.AgePriorityListRepresentation;
import com.example.vaccinationmanagementsystem.representation.AgePriorityRepresentation;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AgePriorityService {

    private AgePriorityRepository repository;
    private AgeRangeRepository ageRangeRepository;

    @Autowired
    public AgePriorityService(AgePriorityRepository repository, AgeRangeRepository ageRangeRepository) {
        this.repository = repository;
        this.ageRangeRepository = ageRangeRepository;
    }

    public GeneralResponseStatus retrieveAll() {
        GeneralResponseStatus generalResponseStatus = new GeneralResponseStatus();
        generalResponseStatus.setData(new AgePriorityListRepresentation(repository.findAll().stream()
                .map(AgePriority::toRepresentation)
                .collect(Collectors.toList())));
        return generalResponseStatus;
    }

    public GeneralResponseStatus update(Long id, AgePriorityRepresentation agePriority) {
        return new GeneralResponseStatus(repository.findById(id).map(savedAgePriority -> {
            return ageRangeRepository.findById(agePriority.getIdAgeRange()).map(result -> {
                savedAgePriority.setAgeRange(result);
                savedAgePriority.setValue(agePriority.getValue());
                return repository.save(savedAgePriority).toRepresentation();
            }).orElseThrow(() -> new VaccineEntityNotFoundException("AgeRange not found with id:" + agePriority.getIdAgeRange()));
        }).orElseThrow(() -> new VaccineEntityNotFoundException("AgePriority not found with id:" + id)));
    }

    public GeneralResponseStatus create(AgePriorityRepresentation agePriority) {
        return ageRangeRepository.findById(agePriority.getIdAgeRange()).map(
                        result -> new GeneralResponseStatus(repository.save(new AgePriority(result, agePriority.getValue()))))
                .orElseThrow(() -> new VaccineEntityNotFoundException("AgeRange not found with id " + agePriority.getIdAgeRange()));
    }

    public GeneralResponseStatus delete(Long id) {
        repository.deleteById(id);
        return new GeneralResponseStatus();
    }
}
