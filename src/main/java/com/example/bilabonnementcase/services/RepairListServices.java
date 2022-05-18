package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.repositories.IRepository;

//Author: Güler
public class RepairListServices {

    private final IRepository<RepairList> repository;

    public RepairListServices(IRepository<RepairList> repairListRepository) {
        this.repository = repairListRepository;
    }

    public String createRepairList(RepairList repairList){

        if(repository.create(repairList) == true){
            return "redirect:/createRepairListSuccessPage";
        }
        return "redirect:/errorPage";
    }

    public String deleteRepairList(int repairListId){

        if(repository.delete(repairListId) == true){
            return "redirect:/deleteRepairListSuccessPage";
        }
        return "redirect:/errorPage";
    }

    public String getCollumnName(String input){
        String collumn = "";

        if (input.equals("start")){
            collumn = "repair_start";
        } else if(input.equals("car")){
            collumn = "car_number";
        }

        return collumn;
    }


}
