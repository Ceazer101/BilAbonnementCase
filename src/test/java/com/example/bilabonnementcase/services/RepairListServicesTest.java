package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.repositories.DummyRepairlistRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepairListServicesTest {

    DummyRepairlistRepo drRepo = new DummyRepairlistRepo();

    @Test
    void goToCreateRepairList() {
    }

    @Test
    void hasCarReturnedAfterEndedLeasePeriod() {
    }

    @Test
    void getRepairListId() {
        //Arrange
        int carNumber = 4;
        int expectedResult = 2;

        //Act
        int actualResult = drRepo.getRepairListIdFromCarNumber(carNumber);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

}