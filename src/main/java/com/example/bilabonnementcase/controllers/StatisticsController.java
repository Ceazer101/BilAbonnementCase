package com.example.bilabonnementcase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    @GetMapping("/viewStatistics")
    public String viewStatistics(){
        return "viewPages/viewStatistics";
    }
}
