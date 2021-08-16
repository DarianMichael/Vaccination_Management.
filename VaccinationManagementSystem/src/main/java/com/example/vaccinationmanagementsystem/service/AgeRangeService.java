package com.example.vaccinationmanagementsystem.service;

import com.example.vaccinationmanagementsystem.exception.VaccineEntityNotFoundException;
import com.example.vaccinationmanagementsystem.models.AgeRange;
import com.example.vaccinationmanagementsystem.repository.AgeRangeRepository;
import com.example.vaccinationmanagementsystem.representation.AgeRangeListRepresentation;
import com.example.vaccinationmanagementsystem.representation.AgeRangeRepresentation;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AgeRangeService {

    private AgeRangeRepository repository;

    @Autowired
    public AgeRangeService(AgeRangeRepository repository) {
        this.repository = repository;
    }

    public GeneralResponseStatus retrieveAll() {
        GeneralResponseStatus generalResponseStatus = new GeneralResponseStatus();
        generalResponseStatus.setData(new AgeRangeListRepresentation(repository.findAll().stream()
                .map(AgeRange::toRepresentation)
                .collect(Collectors.toList())));
        return generalResponseStatus;
    }

    public GeneralResponseStatus update(Long id, AgeRangeRepresentation ageRange) {
        return new GeneralResponseStatus(repository.findById(id).map(savedAgeRange -> {
            savedAgeRange.setLowThreshold(ageRange.getLowThreshold());
            savedAgeRange.setHighThreshold(ageRange.getHighThreshold());
            return repository.save(savedAgeRange).toRepresentation();
        }).orElseThrow(() -> new VaccineEntityNotFoundException("AgeRange not found with id:" + id)));
    }

    public GeneralResponseStatus create(AgeRangeRepresentation ageRange) {
        return new GeneralResponseStatus(repository.save(ageRange.toEntity()).toRepresentation());
    }

    public GeneralResponseStatus delete(Long id) {
        repository.deleteById(id);
        return new GeneralResponseStatus();
    }
}
