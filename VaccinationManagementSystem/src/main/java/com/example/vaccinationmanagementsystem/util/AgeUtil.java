package com.example.vaccinationmanagementsystem.util;

import com.example.vaccinationmanagementsystem.models.Person;


import java.time.LocalDate;
import java.time.Period;

public class AgeUtil {

    public static Integer computeAge(Person person) {
        return Period.between(person.getBirthday(), LocalDate.now()).getYears();
    }
}
