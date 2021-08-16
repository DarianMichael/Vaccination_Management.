package com.example.vaccinationmanagementsystem;

import com.example.vaccinationmanagementsystem.enums.Disease;
import com.example.vaccinationmanagementsystem.enums.Status;
import com.example.vaccinationmanagementsystem.representation.CitizenRepresentation;
import com.example.vaccinationmanagementsystem.representation.PersonRepresentation;

import java.time.LocalDate;

public class TestUtil {
    private TestUtil() {

    }

    public static PersonRepresentation createPersonRepresentation() {
        return new PersonRepresentation("1757332018", "Darian", "", "Duarte", "Martinez",
                "darian@correo.com", LocalDate.of(1983, 6, 16));
    }

    public static CitizenRepresentation createCitizen() {
        return new CitizenRepresentation(1L, Disease.NONE, Status.PENDING, LocalDate.now(), null,
                createPersonRepresentation());
    }


}
