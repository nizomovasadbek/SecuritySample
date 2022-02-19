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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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
    public ModelAndView registerUser(@ModelAttribute("user") User user, HttpServletRequest request){
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        user.setPassword(encode.encode(user.getPassword()));

        user.setExpiryDate(new MyDate().calculateExpiryDate());
        user.setEnabled(false);

        String token = UUID.randomUUID().toString();
        user.setToken(token);

        myRepository.addSave(user);
        String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath() + "/regConfirm" + user;
        sendEmail.sendMail(appUrl);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/regConfirm")
    public String confirmation(@RequestParam("token") String token){
        User user = myRepository.getUserByToken(token);

        user.setEnabled(true);

        myRepository.update(user);

        return "/login";
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
