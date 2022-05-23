package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.repositories.IRepository;
import com.example.bilabonnementcase.repositories.LeaseContractRepository;

//Author: Maja, Güler
public class LeaseServices {

    LeaseContractRepository leaseContractRepository = new LeaseContractRepository();
    private final IRepository<LeaseContract> repository;

    public LeaseServices(IRepository<LeaseContract> leaseContractRepository) {
        this.repository =  leaseContractRepository;
    }

    public String createLeaseContract(LeaseContract leaseContract){

        if(repository.create(leaseContract) == true){
            return "redirect:/leaseSuccess";
        }
        return "redirect:/errorPage";
    }
    
    public String deleteLeaseContract(int leaseContractId){

        if(repository.delete(leaseContractId) == true){
            return "redirect:/deleteLeaseSuccess";
        }
        return "redirect:/errorPage";
    }


}
