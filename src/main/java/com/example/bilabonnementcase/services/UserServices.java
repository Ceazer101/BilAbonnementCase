package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.Role;
import com.example.bilabonnementcase.models.User;
import com.example.bilabonnementcase.repositories.UserRepository;

//Author: Maja, Güler
public class UserServices {

    private final UserRepository userRepository = new UserRepository();

    public String validateLogin(User user){

        if(userRepository.validateLoginInformation(user) == true){

            user.setRole(userRepository.getRoleByUsername(user.getUsername()));

            if (user.getRole().equals(Role.ADMIN)){
                return "redirect:/admin";
            } else if(user.getRole().equals(Role.DATAREGISTRATOR)){
                return "redirect:/dataRegistrator";
            } else if(user.getRole().equals(Role.DAMAGEREGISTRATOR)){
                return "redirect:/damageRegistrator";
            } else if (user.getRole().equals(Role.BUSINESSDEVELOPER)){
                return "redirect:/businessDeveloper";
            }
        }

        return "redirect:/errorPage";
    }



}
