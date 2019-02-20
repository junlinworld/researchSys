package com.example.sun.common;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class Validateunit {
    static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> List<String> Validate(T obj) {

        Set<ConstraintViolation<T>> messages = validator.validate(obj);

        if (!messages.isEmpty()) {
            List<String> result = new ArrayList<>();

            for (ConstraintViolation c : messages) {
                result.add(c.getMessage());
            }

            return result;
        }

        return null;

    }
}
