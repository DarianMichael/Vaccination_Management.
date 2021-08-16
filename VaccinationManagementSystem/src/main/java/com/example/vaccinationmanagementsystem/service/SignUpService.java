package com.example.vaccinationmanagementsystem.service;

import com.example.vaccinationmanagementsystem.exception.DuplicatedPersonException;
import com.example.vaccinationmanagementsystem.models.Citizen;
import com.example.vaccinationmanagementsystem.models.Person;
import com.example.vaccinationmanagementsystem.repository.CitizenRepository;
import com.example.vaccinationmanagementsystem.repository.PersonRepository;
import com.example.vaccinationmanagementsystem.representation.CitizenRepresentation;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SignUpService {


    private CitizenRepository repository;
    private PersonRepository personRepository;

    @Autowired
    public SignUpService(CitizenRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public GeneralResponseStatus singUp(CitizenRepresentation citizenRepresentation) {
        Citizen citizenToSave = citizenRepresentation.toEntity();
        personRepository.findById(Long.parseLong(citizenRepresentation.getPerson().getId())).map(person -> {
            throw new DuplicatedPersonException("Person already exists");
        });
        Person savedPerson = personRepository.save(citizenToSave.getPerson());
        citizenToSave.setPerson(savedPerson);
        citizenToSave.setRegistrationDate(LocalDate.now());
        repository.save(citizenToSave);
        return new GeneralResponseStatus();

    }

}
