package com.example.bilabonnementcase.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class RepairListController {


    @GetMapping("/create-repair")
    public String createRepairList(){
        return "createRepairList";
    }

}
