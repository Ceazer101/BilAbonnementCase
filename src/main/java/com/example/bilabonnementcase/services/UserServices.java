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

            if(user.getRole().equals(Role.DATAREGISTRATOR)){
                return "redirect:/data-reg";
            } else if(user.getRole().equals(Role.DAMAGEREGISTRATOR)){
                return "redirect:/damage-reg";
            } else if (user.getRole().equals(Role.BUSINESSDEVELOPER)){
                return "redirect:/business-dev";
            }
        }

        return "redirect:/error-page";
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public String loginResponse(String username, String password, HttpSession session){
        String response = validateLogin(username, password);
        if(!response.equals("redirect:/error-page")){
            User loginUser = getUserByUsername(username);
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("currentLoggedInUser", loginUser);
        }
        return response;
    }

    public boolean checkLoginStatus(HttpSession session){
        if(session.getAttribute("isLoggedIn") == null){
            return false;
        }
        return true;
    }

    public Role verifyUserRole(HttpSession session){
        if(session.getAttribute("currentLoggedInUser") == null){
            session.setAttribute("currentLoggedInUser", new User());
        }

        User currentUser = (User) session.getAttribute("currentLoggedInUser");
        Role currentUserRole = currentUser.getRole();
        return currentUserRole;
    }

}
