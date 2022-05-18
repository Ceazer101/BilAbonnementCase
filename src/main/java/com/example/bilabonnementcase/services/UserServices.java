package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.Role;
import com.example.bilabonnementcase.models.User;
import com.example.bilabonnementcase.repositories.UserRepository;

import javax.servlet.http.HttpSession;

//Author: Maja, Güler
public class UserServices {

    private final UserRepository userRepository = new UserRepository();

    public String validateLogin(String username, String password){
        User user = null;

        if(userRepository.validateLoginInformation(username, password) == true){

            user = userRepository.getUserByUsername(username);
            user.setRole(user.getRole());

            if (user.getRole().equals(Role.ADMIN)){
                return "redirect:/admin";
            } else if(user.getRole().equals(Role.DATAREGISTRATOR)){
                return "redirect:/data-reg";
            } else if(user.getRole().equals(Role.DAMAGEREGISTRATOR)){
                return "redirect:/damageRegistrator";
            } else if (user.getRole().equals(Role.BUSINESSDEVELOPER)){
                return "redirect:/businessDeveloper";
            }
        }

        return "redirect:/error-page";
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }





}
