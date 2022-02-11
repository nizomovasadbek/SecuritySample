package com.security.controller;

import com.security.mail.SendEmail;
import com.security.model.User;
import com.security.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    public MyRepository myRepository;

    @Autowired
    private SendEmail sendEmail;

    @GetMapping("/signup")
    public String registrationForm(){
        return "/register";
    }

    @PostMapping("/user/register")
    public ModelAndView registerUser(@ModelAttribute("user") User user){
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        user.setPassword(encode.encode(user.getPassword()));

        user.setExpiryDate(new MyDate().calculateExpiryDate());
        user.setEnabled(false);

        myRepository.addSave(user);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/supervisor")
    public String supervisor(){
        return "supervisor";
    }
}
