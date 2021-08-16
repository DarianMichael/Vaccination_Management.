package com.example.vaccinationmanagementsystem.validator.names;


import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class NameValidator implements ConstraintValidator<NameConstraint, String> {

    public static final String PATTERN = "[a-zA-Z]{2,12}$";

    @Override
    public void initialize(NameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
