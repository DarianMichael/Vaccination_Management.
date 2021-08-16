package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.enums.Disease;
import com.example.vaccinationmanagementsystem.enums.Status;
import com.example.vaccinationmanagementsystem.mapper.EntityMappable;
import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import com.example.vaccinationmanagementsystem.models.Citizen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenRepresentation implements BaseRepresentation, EntityMappable<Citizen> {
    private Long id;
    @NotNull
    public Disease disease;
    @NotNull
    public Status status;
    public LocalDate registrationDate;
    public LocalDate scheduledDate;
    @Valid
    private PersonRepresentation person;

    @Override
    public Citizen toEntity() {
        return new Citizen(disease, status, registrationDate, scheduledDate, person.toEntity());
    }
}
