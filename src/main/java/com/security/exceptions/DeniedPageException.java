package com.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Denied page")
public class DeniedPageException extends RuntimeException {

    @GetMapping("/signup")
    public String deniedPage(Model model){
        return "denied";
    }
}
