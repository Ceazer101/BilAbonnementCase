package com.example.bilabonnementcase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RepairListController {


    @GetMapping("/create-repair")
    public String createRepairList(){
        return "createRepairList";
    }

    @GetMapping("/createRepairListSuccesPage")
    public String createRepairListSuccesPage(){
        return "repairListSuccessPage";
    }


    @GetMapping("/deleteRepairList")
    public String deleteRepairList(){
        return "deleteRepairList";
    }

    @GetMapping("/deleteRepairListSuccessPage")
        public String deleteRepairListSuccessPage(){
            return "deleteRepairListSuccessPage";
        }




}
