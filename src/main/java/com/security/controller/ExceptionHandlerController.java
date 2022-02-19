package com.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionHandlerController {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Denied page")
    @ExceptionHandler(Exception.class)
    public String PageDenied(){
        return "denied";
    }

}
