package com.example.bilabonnementcase.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


//Author: Maja
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/error-page")
    public String errorPage(){
        return "errorPages/genericErrorPage";
    }

}
