package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.repositories.IRepository;

public class RepairListServices {

    private final IRepository<RepairList> repository;

    public RepairListServices(IRepository<RepairList> repairListRepository) {
        this.repository = repairListRepository;
    }

    public String deleteRepairList(int repairListId){

        if(repository.delete(repairListId) == true){
            return "redirect:/deleteRepairListSuccessPage";
        }
        return "redirect:/repairListError";
    }
}
