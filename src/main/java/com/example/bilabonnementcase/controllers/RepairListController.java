package com.example.bilabonnementcase.controllers;

import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.repositories.LeaseContractRepository;
import com.example.bilabonnementcase.repositories.RepairListRepository;
import com.example.bilabonnementcase.services.LeaseServices;
import com.example.bilabonnementcase.services.RepairListServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RepairListController {

    private RepairListServices repairListServices = new RepairListServices(new RepairListRepository());


    @GetMapping("/create-repair")
    public String createRepairList(){
        return "createPages/createRepairList";
    }

    @GetMapping("/createRepairListSuccesPage")
    public String createRepairListSuccesPage(){
        return "successPages/createRepairListSuccessPage";
    }


    @GetMapping("/deleteRepairList")
    public String deleteRepairList(){
        return "deletePages/deleteRepairList";
    }

    @GetMapping("/deleteRepairListSuccessPage")
        public String deleteRepairListSuccessPage(){
            return "successPages/deleteRepairListSuccessPage";
        }

    @GetMapping("/repairListError")
    public String leaseContractErrorPage(){
        return "errorPage";
    }

    @PostMapping("/createRepairList")
    public String createRepairList(WebRequest dataFromForm){
        int repairListId = -1;
        int damageId = -1;
        String repairStart = dataFromForm.getParameter("repairStart");
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));

        RepairList tempRepairList = new RepairList(repairListId, damageId, repairStart, carNumber);

        String returnSite = repairListServices.createRepairList(tempRepairList);

        return returnSite;
    }

    @PostMapping("/deleteRepairList")
    public String deleteLeaseContract(WebRequest dataFromForm){
        int repairListId = Integer.parseInt(dataFromForm.getParameter("id"));

        String returnSite = repairListServices.deleteRepairList(repairListId);

        return returnSite;
    }
}
