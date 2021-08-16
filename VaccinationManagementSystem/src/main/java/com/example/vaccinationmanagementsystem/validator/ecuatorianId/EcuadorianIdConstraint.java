package com.example.vaccinationmanagementsystem.validator.ecuatorianId;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EcuadorianIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EcuadorianIdConstraint {
    String message() default "Invalid ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
