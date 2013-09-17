package com.springmvc.test.controller;

import com.springmvc.test.entity.User;
import com.springmvc.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller

public class UserController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @RequestMapping(value = "user/add", method = {RequestMethod.GET})
    public String add(HttpServletRequest request, Model model) {
        userService.save((User) model);
        return "index";
    }

    @RequestMapping(value = "user/register", method = {RequestMethod.GET})
    public String register() {
        return "user/register";
    }
}
