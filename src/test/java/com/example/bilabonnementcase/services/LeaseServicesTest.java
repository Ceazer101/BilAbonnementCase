package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.repositories.DummyLeaseRepo;
import com.example.bilabonnementcase.repositories.LeaseContractRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;

class LeaseServicesTest {

    @Test
    void createLeaseContract() {
        //Arrange
        DummyLeaseRepo repo = new DummyLeaseRepo();
        LeaseServices service = new LeaseServices(repo);

        LeaseContract otherTempLeaseContract = new LeaseContract(-1, "Chrisl", 6566, 2, "djdddf");
        LeaseContract tempLeaseContract = new LeaseContract(-1, "Chris", 666, 4, "djdf");

        //Act
        String actual = service.createLeaseContract(otherTempLeaseContract);
        String expectet;

        String actualfault = service.createLeaseContract(tempLeaseContract);
        String expectetfault2;

       //Assert
        if(repo.create(otherTempLeaseContract) == true){
            expectet = "redirect:/leaseSuccess";
            assertEquals(expectet, actual);
        }

        if(repo.create(tempLeaseContract) == false){
            expectetfault2 = "redirect:/leaseError";
            assertEquals(expectetfault2, actualfault);
        }
    }

    @Test
    void deleteLeaseContract() {
        //Arrange
        LeaseContractRepository repo = new LeaseContractRepository();
        LeaseServices service = new LeaseServices(repo);

    }
}