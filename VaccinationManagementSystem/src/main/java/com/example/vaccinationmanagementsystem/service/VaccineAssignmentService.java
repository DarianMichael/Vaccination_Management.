package com.example.vaccinationmanagementsystem.service;

import com.example.vaccinationmanagementsystem.enums.Disease;
import com.example.vaccinationmanagementsystem.models.*;
import com.example.vaccinationmanagementsystem.repository.*;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.util.AgeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VaccineAssignmentService {
    public static final String MAX_PEOPLE_PER_DAY = "peoplePerDay";
    private ParamRepository paramRepository;
    private VaccineRepository vaccineRepository;
    private AgeRangeRepository ageRangeRepository;
    private AgePriorityRepository agePriorityRepository;
    private DiseasePriorityRepository diseasePriorityRepository;
    private CitizenRepository citizenRepository;

    private List<Vaccine> vaccines;
    private List<AgeRange> ageRangeList;
    private List<AgePriority> agePriorities;
    private List<DiseasePriority> diseasePriorities;
    private int maxPeopleByDay;



    public GeneralResponseStatus makeAssigment() {
        initValues();
        List<Citizen> citizens = retrieveCitizenSortedList();
        for (Citizen citizen : citizens) {
            processCitizen(citizen);
        }
        return null;
    }

    private Optional<Vaccine> processCitizen(Citizen citizen) {
        int age = AgeUtil.computeAge(citizen.getPerson());
        Long ageId = computeAgeId(citizen);
        return ageRangeList.stream().
                filter(ageRange -> ageRange.equals(ageId))
                .findFirst().map(ageRange -> ageRange.getVaccine().stream()
                        .max(Comparator.comparingInt(Vaccine::getQuantity))
                        .get()
                );
    }

    private List<Citizen> retrieveCitizenSortedList() {
        return citizenRepository.findAll().stream()
                .peek(citizen -> {
                    Long ageId = computeAgeId(citizen);
                    citizen.setPriority(computeAgePriority(ageId) + computeDiseasePriority(citizen.getDisease()));
                })
                .sorted(Comparator.comparing(Citizen::getRegistrationDate))
                .sorted(Comparator.comparingInt(Citizen::getPriority)).collect(Collectors.toList());
    }

    private void initValues() {
        vaccines = vaccineRepository.findAll();
        ageRangeList = ageRangeRepository.findAll();
        diseasePriorities = diseasePriorityRepository.findAll();
        agePriorities = agePriorityRepository.findAll();
        maxPeopleByDay = Integer.parseInt(paramRepository.findParamByName(MAX_PEOPLE_PER_DAY).orElse(""));
    }

    private int computeDiseasePriority(Disease disease) {
        return diseasePriorities.stream()
                .filter(diseasePriority -> disease == diseasePriority.getDisease())
                .findFirst()
                .map(DiseasePriority::getValue)
                .orElse(0);
    }

    private int computeAgePriority(Long ageId) {
        return agePriorities.stream()
                .filter(agePriority -> Objects.equals(agePriority.getId(), ageId))
                .findFirst()
                .map(AgePriority::getValue).orElse(0);
    }

    private Long computeAgeId(Citizen citizen) {
        int age = AgeUtil.computeAge(citizen.getPerson());
        return ageRangeList.stream()
                .filter(ageRange -> age >= ageRange.getLowThreshold())
                .filter(ageRange -> age <= ageRange.getHighThreshold())
                .findFirst()
                .map(AgeRange::getId).orElse(0L);
    }

}
