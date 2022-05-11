package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.repositories.LeaseContractRepository;
import org.springframework.web.context.request.WebRequest;

public class LeaseServices {

    private LeaseContractRepository leaseContractRepository = new LeaseContractRepository();

    public String createLeaseContract(WebRequest dataFromForm){

        int leaseContractId = -1;
        String username = dataFromForm.getParameter("username");
        String leasePeriod = dataFromForm.getParameter("leasePeriod");
        int leasePrice = Integer.parseInt(dataFromForm.getParameter("leasePrice"));
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));
        String fileName = dataFromForm.getParameter("fileName");

        LeaseContract tempLeaseContract = new LeaseContract(leaseContractId, username, leasePeriod, leasePrice, 
                carNumber, fileName);

        if(leaseContractRepository.create(tempLeaseContract) == true){
            return "redirect:/leaseSuccess";
        }
        return "redirect:/leaseError";
    }
    
    public String deleteLeaseContract(WebRequest dataFromForm){

        int leaseContractId = Integer.parseInt(dataFromForm.getParameter("id"));

        if(leaseContractRepository.delete(leaseContractId) == true){
            return "redirect:/deleteLeaseSuccess";
        }
        return "redirect:/leaseError";
    }
}
