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


    @GetMapping("/getCreateLeaseContract")
    public String createLeaseContract(){
        return "createLeaseContract";
    }

    @GetMapping("/leaseSuccess")
    public String leaseContractSuccessPage(){
        return "leaseContractSuccessPage";
    }

    @GetMapping("/leaseError")
    public String leaseContractErrorPage(){
        return "leaseContractErrorPage";
    }

    @GetMapping("/deleteLeaseSuccess")
    public String deleteLeaseSuccessPage(){
        return "deleteLeaseSuccessPage";
    }

    @GetMapping("/deleteLease")
    public String deleteLeaseContract(){
        return "deleteLeaseContract";
    }

    @PostMapping("/createLeaseContract")
    public String createLeaseContract(WebRequest dataFromForm){

        String returnSite = leaseServices.createLeaseContract(dataFromForm);

        return returnSite;
    }

    @PostMapping("/deleteLeaseContract")
    public String deleteLeaseContract(WebRequest dataFromForm){

        String returnSite = leaseServices.deleteLeaseContract(dataFromForm);

        return returnSite;
    }
}
