package com.example.bilabonnementcase.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class CarController {


    @GetMapping("/view-cars")
    public String viewListOfCars(){
        return "viewListOfCars";
    }


}
