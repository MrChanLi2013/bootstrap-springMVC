package com.springmvc.test.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;


public class UserTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void nameShouldNotEmpty() {
        User user = new User("", "123", "1@qq.com");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        assertEquals(1, constraintViolations.size());
        assertEquals(
                "用户名不能为空",
                constraintViolations.iterator().next().getMessage()
        );
    }
}
