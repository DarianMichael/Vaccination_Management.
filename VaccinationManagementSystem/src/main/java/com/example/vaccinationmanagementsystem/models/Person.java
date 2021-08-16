package com.example.vaccinationmanagementsystem.models;


import com.example.vaccinationmanagementsystem.mapper.RepresentationMappable;
import com.example.vaccinationmanagementsystem.marker.BaseEntity;
import com.example.vaccinationmanagementsystem.representation.PersonRepresentation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person implements BaseEntity, RepresentationMappable<PersonRepresentation> {
    @Id
    private Long id;
    private String firstName;
    private String middleName;
    private String fistLastName;
    private String secondLastName;
    private String email;
    private LocalDate birthday;

    @Override
    public PersonRepresentation toRepresentation() {
        return new PersonRepresentation(id.toString(), firstName, middleName, fistLastName, secondLastName, email, birthday);
    }
}