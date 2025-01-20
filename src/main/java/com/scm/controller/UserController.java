package com.scm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.helpers.Helper;

@Controller
@RequestMapping("/user")
public class UserController {
    // user database page

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        System.out.println("user-dashboad");
        return "user/dashboard";
    }

    // user profile page
    @RequestMapping(value = "/profile")
    public String userProfile(Authentication authentication) {
        String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("user logged in: {}", username);
        return "user/profile";
    }

    // user add contacts page

    // user view contacts

    // user edit contacts

    // user delete contacts

}
