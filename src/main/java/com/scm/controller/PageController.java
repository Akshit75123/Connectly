package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

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
    public String register(Model model) {
        // System.out.println("Services page loading");
        // System.out.println("Signup");
        UserForm userForm = new UserForm();
        // userForm.setName("Akshit");
        // userForm.setAbout("this is about");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // processing form
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)

    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        // System.out.println("Processing form");
        // fetch form data
        System.out.println(userForm);
        // validate form data

        // save into database -- using UserService
        // UserForm --> User
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic(
        // "https://static.vecteezy.com/system/resources/thumbnails/020/765/399/small/default-profile-account-unknown-icon-black-silhouette-free-vector.jpg")
        // .build();
        // Avoided Builder as it is not linking stable with default value
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(
                "https://static.vecteezy.com/system/resources/thumbnails/020/765/399/small/default-profile-account-unknown-icon-black-silhouette-free-vector.jpg");
        User saveUser = userService.saveUser(user);
        System.out.println("user is saved");
        // message='Registration Successful'

        // add the message -- using session
        Message mess = Message.builder().content("Registration Successfull").type(MessageType.green).build();
        session.setAttribute("message", mess);

        // redirect to login page
        return "redirect:/register";
    }

}
