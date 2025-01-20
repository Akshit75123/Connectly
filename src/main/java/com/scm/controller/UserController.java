package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    // user database page

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String userDashboard() {
        System.out.println("user-dashboad");
        return "user/dashboard";
    }

    // user profile page
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String userProfile() {
        System.out.println("user-profile");
        return "user/profile";
    }

    // user add contacts page

    // user view contacts

    // user edit contacts

    // user delete contacts

}
