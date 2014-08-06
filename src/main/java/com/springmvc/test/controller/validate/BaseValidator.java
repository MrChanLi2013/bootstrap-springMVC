package com.springmvc.test.controller.validate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BaseValidator {
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    protected Map<String, String> validate(Object model) {
        Map<String, String> messagesMap = new HashMap<String, String>();
        makeMap(model, messagesMap);
        return messagesMap;
    }

    private void makeMap(Object model, Map<String, String> messagesMap) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(model);
        for (Iterator<ConstraintViolation<Object>> iterator = constraintViolations.iterator(); iterator.hasNext(); ) {
            ConstraintViolation<Object> next = iterator.next();
            messagesMap.put(next.getPropertyPath().toString(), next.getMessage());
        }
    }
}
