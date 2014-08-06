package com.springmvc.test.controller.validate;

import com.springmvc.test.entity.User;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class BaseValidatorTest {
    @Test
    public void testValidate() throws Exception {
        BaseValidator baseValidator = new BaseValidator();
        Map<String,String> stringMap = baseValidator.validate(new User("", "123456", "123@qq.com"));
        assertEquals(1, stringMap.size());
        assertEquals("用户名不能为空", stringMap.get("username"));
    }
}
