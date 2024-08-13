package org.example.example2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyCustomValidator implements ConstraintValidator<MyCustomValidation, String> {

    private int min;
    private int max;

    @Override
    public void initialize(MyCustomValidation constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // or true depending on how you want to handle null values
        }
        int length = value.length();
        return length >= min && length <= max;
    }
}

