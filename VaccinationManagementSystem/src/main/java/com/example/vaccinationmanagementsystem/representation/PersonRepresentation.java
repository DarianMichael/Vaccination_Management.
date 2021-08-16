package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.mapper.EntityMappable;
import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import com.example.vaccinationmanagementsystem.models.Person;
import com.example.vaccinationmanagementsystem.validator.ecuatorianId.EcuadorianIdConstraint;
import com.example.vaccinationmanagementsystem.validator.names.NameConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRepresentation implements BaseRepresentation, EntityMappable<Person> {
    @EcuadorianIdConstraint
    @NotBlank
    private String id;
    @NotBlank
    @NameConstraint
    private String firstName;
    private String middleName;
    @NotBlank
    @NameConstraint
    private String firstLastName;
    @NotBlank
    @NameConstraint
    private String secondLastName;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private LocalDate birthday;

    @Override
    public Person toEntity() {
        return new Person(Long.parseLong(id), firstName, middleName, firstLastName, secondLastName, email, birthday);
    }
}
