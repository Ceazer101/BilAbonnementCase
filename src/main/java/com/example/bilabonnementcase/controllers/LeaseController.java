package com.example.bilabonnementcase.controllers;

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
        return "createPages/createLeaseContract";
    }

    @GetMapping("/leaseSuccess")
    public String leaseContractSuccessPage(){
        return "successPages/leaseContractSuccessPage";
    }

    @GetMapping("/leaseError")
    public String leaseContractErrorPage(){
        return "errorPage";
    }

    @GetMapping("/deleteLeaseSuccess")
    public String deleteLeaseSuccessPage(){
        return "successPages/deleteLeaseSuccessPage";
    }

    @GetMapping("/deleteLease")
    public String deleteLeaseContract(){
        return "deletePages/deleteLeaseContract";
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
