package com.example.bilabonnementcase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {


    @GetMapping("/view-cars")
    public String viewListOfCars(){
        return "viewListOfCars";
    }


}
