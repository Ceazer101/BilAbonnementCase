package com.example.bilabonnementcase.controllers;

import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.repositories.LeaseContractRepository;
import com.example.bilabonnementcase.services.LeaseServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;


//Author: Güler
@Controller
public class LeaseController {

    private LeaseServices leaseServices = new LeaseServices(new LeaseContractRepository());

    @GetMapping("/getCreateLeaseContract")
    public String createLeaseContract(){
        return "createPages/createLeaseContract";
    }

    @GetMapping("/viewLeaseContracts")
    public String viewLeaseContracts(Model model){
        System.out.println(model.addAttribute("allLeaseContracts", leaseServices.showLeaseContracts()));
        return "viewPages/viewLeaseContracts";
    }

    @GetMapping("/update-lease")
    public String updateLeaseContract(){
        return "updatePages/updateLeaseContract";
    }

    @PostMapping("updateLeaseContract")
    public String updateLeaseContract(WebRequest dataFromForm){
        int leaseId = Integer.parseInt(dataFromForm.getParameter("leaseId"));
        String username = dataFromForm.getParameter("username");
        String leaseStart = dataFromForm.getParameter("leaseStart");
        String leaseEnd = dataFromForm.getParameter("leaseEnd");
        int leasePrice = Integer.parseInt(dataFromForm.getParameter("leasePrice"));
        String fileName = dataFromForm.getParameter("fileName");
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));

        LeaseContract tempRepairList = new LeaseContract(leaseId, username, leaseStart, leaseEnd, leasePrice, fileName, carNumber);

        String returnSite = leaseServices.updateLeaseContract(tempRepairList);

        return returnSite;
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
        String leaseStart = dataFromForm.getParameter("leaseStart");
        String leaseEnd = dataFromForm.getParameter("leaseEnd");
        int leasePrice = Integer.parseInt(dataFromForm.getParameter("leasePrice"));
        String fileName = dataFromForm.getParameter("fileName");
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));

        LeaseContract tempLeaseContract = new LeaseContract(leaseContractId, username, leaseStart, leaseEnd, leasePrice, fileName,
                carNumber);

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
