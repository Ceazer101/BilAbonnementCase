package com.example.bilabonnementcase.controllers;

import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.repositories.IRepository;
import com.example.bilabonnementcase.repositories.LeaseContractRepository;
import com.example.bilabonnementcase.services.LeaseServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LeaseController {

    private LeaseServices leaseServices = new LeaseServices(new LeaseContractRepository());

    @GetMapping("/getCreateLeaseContract")
    public String createLeaseContract(){
        return "createPages/createLeaseContract";
    }

    @GetMapping("/leaseSuccess")
    public String leaseContractSuccess(){
        return "successPages/leaseContractSuccessPage";
    }

    @GetMapping("/leaseError")
    public String leaseContractError(){
        return "errorPage";
    }

    @GetMapping("/deleteLeaseSuccess")
    public String deleteLeaseSuccess(){
        return "successPages/deleteLeaseSuccessPage";
    }

    @GetMapping("/deleteLease")
    public String deleteLeaseContract(){
        return "deletePages/deleteLeaseContract";
    }

    @PostMapping("/createLeaseContract")
    public String createLeaseContract(WebRequest dataFromForm){
        int leaseContractId = -1;
        String username = dataFromForm.getParameter("username");
        int leasePrice = Integer.parseInt(dataFromForm.getParameter("leasePrice"));
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));
        String fileName = dataFromForm.getParameter("fileName");

        LeaseContract tempLeaseContract = new LeaseContract(leaseContractId, username, leasePrice,
                carNumber, fileName);

        String returnSite = leaseServices.createLeaseContract(tempLeaseContract);

        return returnSite;
    }

    @PostMapping("/deleteLeaseContract")
    public String deleteLeaseContract(WebRequest dataFromForm){
        int leaseContractId = Integer.parseInt(dataFromForm.getParameter("id"));

        String returnSite = leaseServices.deleteLeaseContract(leaseContractId);

        return returnSite;
    }
}
