package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page handle");
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("YT", "https://youtube.com/");
        model.addAttribute("git", "https://github.com/Akshit75123");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About page loading");
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services page loading");
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        // System.out.println("Services page loading");
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        // System.out.println("Services page loading");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        // System.out.println("Services page loading");
        return "register";
    }

}
