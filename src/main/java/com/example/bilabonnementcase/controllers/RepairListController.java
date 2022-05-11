package com.example.bilabonnementcase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RepairListController {


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




}
