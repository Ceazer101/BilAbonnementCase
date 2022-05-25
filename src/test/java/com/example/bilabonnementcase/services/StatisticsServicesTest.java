package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.repositories.DummyStatisticsRepo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatisticsServicesTest {

    DummyStatisticsRepo dsRepo = new DummyStatisticsRepo();

    @Test
    void rentedCars() {
        //Arrange
        int expectedResult = 2;

        //Act
        int actualResult = dsRepo.carsRented();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void valueOfRentedCars() {
        //Arrange
        int expectedResult = 2000;

        //Act
        int actualResult = dsRepo.valueOfRentedCars();

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}