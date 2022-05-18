package com.example.bilabonnementcase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//Author: Güler
@Controller
public class UserController {

    @GetMapping("/logOut")
    public String index(){
        return "logOut";
    }

}
