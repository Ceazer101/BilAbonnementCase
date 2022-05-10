package com.example.bilabonnementcase.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class LeaseController {


    @GetMapping("/create-lease")
    public String createLeaseContract(){
        return "createLeaseContract";
    }




}
