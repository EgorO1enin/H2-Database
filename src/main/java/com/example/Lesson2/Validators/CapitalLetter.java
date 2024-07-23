package com.example.Lesson2.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CapitalLetterValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CapitalLetter {
    String message() default "Имя должно начинаться с заглавной буквы";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}