package com.springmvc.test.controller.validate;

import com.springmvc.test.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class UserValidatorTest {
    private UserValidator userValidator;
    private User user;

    @Before
    public void setUp() {
        userValidator = new UserValidator();
        user = new User("test", "123", "123@qq.com");
        user.setConfirmPwd("233");
        user.setVerificationCode("LOIK");
    }

    @Test
    public void testValidate() throws Exception {
        Map map =  userValidator.validate(user, "TXRW");
        assertEquals("验证码输入不正确",map.get("code"));
        assertEquals("两次输入的密码不相同",map.get("password"));
    }
}
