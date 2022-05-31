package com.example.bilabonnementcase.controllers;

import com.example.bilabonnementcase.services.StatisticsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Author: Kenneth
@Controller
public class StatisticsController {

    StatisticsServices service = new StatisticsServices();

    @GetMapping("/viewStatistics")
    public String viewStatistics(Model model){

        model.addAttribute("rentedcars", service.rentedCars());
        model.addAttribute("valueOfRentedCars", service.valueOfRentedCars());

        return "viewPages/viewStatistics";
    }

}
