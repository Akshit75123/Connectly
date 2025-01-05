package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home Page handle");
        model.addAttribute("name","substring Technologies");
        model.addAttribute("YT","SpringBoot");
        model.addAttribute("git","https://github.com/Akshit75123");
        return "home";
    }
}
