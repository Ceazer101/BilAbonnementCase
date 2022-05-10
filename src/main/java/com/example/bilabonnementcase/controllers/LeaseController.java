package com.example.bilabonnementcase.controllers;

import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.services.LeaseServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LeaseController {

    private LeaseServices leaseServices = new LeaseServices();


    @GetMapping("/createLeaseContractGet")
    public String createLeaseContract(){
        return "createLeaseContract";
    }

    @GetMapping("/leaseSuccess")
    public String leaseContractSuccessPage(){
        return "leaseContractSuccessPage";
    }

    @PostMapping("/createLeaseContract")
    public String createLeaseContract(WebRequest dataFromForm){

        String returnSite = leaseServices.createLeaseContract(dataFromForm);

        return returnSite;
    }
}
