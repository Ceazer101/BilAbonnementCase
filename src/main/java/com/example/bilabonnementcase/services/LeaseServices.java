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
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));
        String fileName = dataFromForm.getParameter("fileName");

        LeaseContract tempLeaseContract = new LeaseContract(leaseContractId, username, leasePeriod, carNumber, fileName);

        //leaseContractRepository.create(tempLeaseContract);

        if(leaseContractRepository.create(tempLeaseContract) == true){
            return "redirect:/leaseSuccess";
        }
        return "redirect:/leaseError";
    }
}
