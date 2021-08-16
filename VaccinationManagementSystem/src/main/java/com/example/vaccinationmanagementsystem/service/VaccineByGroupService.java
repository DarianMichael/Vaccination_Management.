package com.example.vaccinationmanagementsystem.service;

import com.example.vaccinationmanagementsystem.exception.VaccineEntityNotFoundException;
import com.example.vaccinationmanagementsystem.repository.AgeRangeRepository;
import com.example.vaccinationmanagementsystem.repository.VaccineRepository;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.representation.VaccineByGroupListRepresentation;
import com.example.vaccinationmanagementsystem.representation.VaccineByGroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class VaccineByGroupService {

    private VaccineRepository vaccineRepository;
    private AgeRangeRepository ageRangeRepository;

    @Autowired
    public VaccineByGroupService(VaccineRepository vaccineRepository, AgeRangeRepository ageRangeRepository) {
        this.vaccineRepository = vaccineRepository;
        this.ageRangeRepository = ageRangeRepository;
    }

    public GeneralResponseStatus retrieveAll() {
        return new GeneralResponseStatus(new VaccineByGroupListRepresentation(vaccineRepository.findAll().stream()
                .flatMap(vaccine -> vaccine.getAges().stream()
                        .map(ageRange -> new VaccineByGroupRepresentation(vaccine.getId(), ageRange.getId()))
                ).collect(Collectors.toList())));
    }

    public GeneralResponseStatus create(VaccineByGroupRepresentation vaccineByGroupRepresentation) {
        Long vaccineId = vaccineByGroupRepresentation.getVaccineId();
        Long ageRangeId = vaccineByGroupRepresentation.getAgeRangeId();
        return vaccineRepository.findById(vaccineId).map(vaccine -> new GeneralResponseStatus(ageRangeRepository.findById(ageRangeId).map(ageRange -> {
            vaccine.getAges().add(ageRange);
            ageRange.getVaccine().add(vaccine);
            vaccineRepository.save(vaccine);
            ageRangeRepository.save(ageRange);
            return vaccineByGroupRepresentation;
        }).orElseThrow(() -> new VaccineEntityNotFoundException("Vaccine not found with id: " + ageRangeId)))).orElseThrow(() -> new VaccineEntityNotFoundException("Vaccine not found with id: " + vaccineId));
    }

    public GeneralResponseStatus delete(Long vaccineId, Long ageRangeId) {
        return vaccineRepository.findById(vaccineId).map(vaccine -> new GeneralResponseStatus(ageRangeRepository.findById(ageRangeId).map(ageRange -> {
            vaccine.getAges().remove(ageRange);
            ageRange.getVaccine().remove(vaccine);
            vaccineRepository.save(vaccine);
            ageRangeRepository.save(ageRange);
            return new GeneralResponseStatus();
        }).orElseThrow(() -> new VaccineEntityNotFoundException("Vaccine not found with id: " + ageRangeId)))).orElseThrow(() -> new VaccineEntityNotFoundException("Vaccine not found with id: " + vaccineId));
    }
}
