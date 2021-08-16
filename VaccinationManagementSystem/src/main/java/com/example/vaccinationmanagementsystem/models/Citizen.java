package com.example.vaccinationmanagementsystem.models;

import com.example.vaccinationmanagementsystem.enums.Disease;
import com.example.vaccinationmanagementsystem.enums.Status;
import com.example.vaccinationmanagementsystem.mapper.RepresentationMappable;
import com.example.vaccinationmanagementsystem.marker.BaseEntity;
import com.example.vaccinationmanagementsystem.representation.CitizenRepresentation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Citizen implements BaseEntity, RepresentationMappable<CitizenRepresentation> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    public Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public Disease disease;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public Status status;
    @Column(nullable = false)
    public LocalDate registrationDate;
    public LocalDate scheduledDate;
    @OneToOne
    private Person person;
    @Transient
    private int priority;

    public Citizen(Disease disease, Status status, LocalDate registrationDate, LocalDate scheduledDate, Person person) {
        this.disease = disease;
        this.status = status;
        this.registrationDate = registrationDate;
        this.scheduledDate = scheduledDate;
        this.person = person;
        priority = 0;
    }

    @Override
    public CitizenRepresentation toRepresentation() {
        return new CitizenRepresentation(id, disease, status, registrationDate, scheduledDate, person.toRepresentation());
    }
}
