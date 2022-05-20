package com.example.bilabonnementcase.controllers;
import com.example.bilabonnementcase.models.Role;
import com.example.bilabonnementcase.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

//Author: Maja, Güler
@Controller
public class UserController {

    private final UserServices userService = new UserServices();

    @GetMapping("/logOut")
    public String logOut(){
        return "logOut";
    }

    @GetMapping("/data-reg")
    public String dataRegistrator(HttpSession session){
        boolean isLoggedIn = userService.checkLoginStatus(session);
        session.setAttribute("isLoggedIn", isLoggedIn);

        Role role = userService.verifyUserRole(session);

        if(isLoggedIn == true && (role.equals(Role.DATAREGISTRATOR) || role.equals(Role.ADMIN))){
            return "menuPages/dataRegistratorMenu";
        } else if(isLoggedIn == false && role.equals(Role.NOROLE)){
            return "redirect:/";
        }
        return "redirect:/";

    }

    @GetMapping("/business-dev")
    public String businessDeveloper(HttpSession session){
        boolean isLoggedIn = userService.checkLoginStatus(session);
        session.setAttribute("isLoggedIn", isLoggedIn);

        Role role = userService.verifyUserRole(session);

        if(isLoggedIn == true && (role.equals(Role.BUSINESSDEVELOPER) || role.equals(Role.ADMIN))){
            return "menuPages/businessDeveloperMenu";
        } else if(isLoggedIn == false && role.equals(Role.NOROLE)){
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping("/damage-reg")
    public String damageRegistrator(HttpSession session){
        boolean isLoggedIn = userService.checkLoginStatus(session);
        session.setAttribute("isLoggedIn", isLoggedIn);

        Role role = userService.verifyUserRole(session);

        if(isLoggedIn == true && (role.equals(Role.DAMAGEREGISTRATOR) || role.equals(Role.ADMIN))){
            return "menuPages/damageRegistratorMenu";
        } else if(isLoggedIn == false && role.equals(Role.NOROLE)){
            return "redirect:/";
        }
        return "redirect:/";
    }

    @PostMapping("/")
    public String loginForm(WebRequest wr, HttpSession session){
        String username = wr.getParameter("username");
        String password = wr.getParameter("password");

        String response = userService.loginResponse(username, password, session);
        return response;
    }

    @GetMapping("/admin")
    public String admin(HttpSession session){
        boolean isLoggedIn = userService.checkLoginStatus(session);
        session.setAttribute("isLoggedIn", isLoggedIn);

        Role role = userService.verifyUserRole(session);

        if(isLoggedIn == true && role.equals(Role.ADMIN)){
            return "menuPages/admin";
        } else if(isLoggedIn == false && role.equals(Role.NOROLE)){
            return "redirect:/";
        }
        return "redirect:/";
    }


}
