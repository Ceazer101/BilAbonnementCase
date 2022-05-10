package com.example.bilabonnementcase.controllers;

import com.example.bilabonnementcase.models.LeaseContract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

public class LeaseController {


    @GetMapping("/create-lease")
    public String createLeaseContract(){
        return "createLeaseContract";
    }

    @PostMapping("/createLeaseContract")
    public String wishListCreation(WebRequest dataFromForm){

        int leaseContractId = -1;
        String username = dataFromForm.getParameter("username");
        String leasePeriod = dataFromForm.getParameter("leasePeriod");
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));
        String fileName = dataFromForm.getParameter("fileName");

        LeaseContract tempLeaseContract = new LeaseContract(leaseContractId, username, leasePeriod, carNumber, fileName);

        //wishListService.createWishList(tempLeaseContract);

        return "redirect:/leaseContractSuccessPage";
    }




}
