package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.Role;
import com.example.bilabonnementcase.models.User;
import com.example.bilabonnementcase.repositories.DummyUserRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServicesTest {

    @Test
    void validateLogin() {
        //Arrange
        DummyUserRepo dummyUserRepo = new DummyUserRepo();

        User user1 = new User("maja", "hej", Role.ADMIN);
        User user2 = new User("maya", "hej", Role.BUSINESSDEVELOPER);
        User user3 = new User("maja", "yej", Role.DATAREGISTRATOR);

        boolean expectedSuccess = true;
        boolean expectedFault = false;

        //Act
        boolean actualResult = dummyUserRepo.validateLoginInformation(user1);
        boolean actualResult2 = dummyUserRepo.validateLoginInformation(user2);
        boolean actualResult3 = dummyUserRepo.validateLoginInformation(user3);

        //Assert
        assertEquals(expectedSuccess, actualResult);
        assertEquals(expectedFault, actualResult2);
        assertEquals(expectedFault, actualResult3);

    }
}