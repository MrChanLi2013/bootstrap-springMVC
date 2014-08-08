package com.springmvc.test.controller;

import com.springmvc.test.controller.validate.UserValidator;
import com.springmvc.test.entity.User;
import com.springmvc.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller

public class UserController extends UserValidator {
    public static final String RANDOM_CODE_KEY = "RANDOMVALIDATECODEKEY";
    @Autowired(required = true)
    @Qualifier(value = "UserService")
    private UserService userService;

    @RequestMapping(value = "user/add", method = {RequestMethod.POST})
    public String add(User model, HttpSession session, Map<String, Map> error) {
        Map<String, String> errorMessages = validate(model, session.getAttribute(RANDOM_CODE_KEY).toString());
        if (errorMessages.isEmpty()) {
            userService.save(model);
            return "index";
        } else {
            error.put("error", errorMessages);
            return "user/register";
        }

    }

    @RequestMapping(value = "user/register", method = {RequestMethod.GET})
    public String register() {
        return "user/register";
    }
}
