package com.jzcradle.validator;


import com.jzcradle.anno.Contains;
import jakarta.validation.ConstraintValidator;

import java.util.List;

public class ContainsValidator implements ConstraintValidator<Contains, String> {

    private List<String> list;

    @Override
    public void initialize(Contains constraintAnnotation) {
        this.list = List.of(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String s, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }
        return list.contains(s);
    }

}
