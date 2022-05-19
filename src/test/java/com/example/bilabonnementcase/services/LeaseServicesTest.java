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

        LeaseContract otherTempLeaseContract = new LeaseContract(-1, "Chrisl", "2017-09-03", "2022-02-04", 6566, "djdddf", 4);
        LeaseContract tempLeaseContract = new LeaseContract(1, "Chris", "2022-02-04", "2023-02-04", 666, "djdf", 2);

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
            expectetfault2 = "redirect:/errorPage";
            assertEquals(expectetfault2, actualfault);
        }
    }

    @Test
    void deleteLeaseContract() {
        //Arrange
        DummyLeaseRepo repo = new DummyLeaseRepo();
        LeaseServices service = new LeaseServices(repo);

        int correctId = 1;
        int falseId = 2;

        String correctExpectedResult = "redirect:/deleteLeaseSuccess";
        String falseExpectedResult = "redirect:/errorPage";

        //Act
        String actualCorrect = service.deleteLeaseContract(correctId);
        String actualFault = service.deleteLeaseContract(falseId);

        //Assert
        assertEquals(correctExpectedResult, actualCorrect);
        assertEquals(falseExpectedResult, actualFault);

    }
}