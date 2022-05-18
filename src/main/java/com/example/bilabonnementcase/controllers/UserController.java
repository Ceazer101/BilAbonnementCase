package com.example.bilabonnementcase.controllers;

import com.example.bilabonnementcase.models.User;
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
    public String index(){
        return "logOut";
    }

    @PostMapping("/logIn")
    public String loginForm(WebRequest wr, HttpSession session){
        String username = wr.getParameter("username");
        String password = wr.getParameter("password");
        User potentialLoginUser = new User(username,password);

        //Check at de er valide
        String response = userService.validateLogin(potentialLoginUser);
        if(!response.equals("redirect:/error-page")){
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("currentLoggedInUser", potentialLoginUser);
            session.setAttribute("role", potentialLoginUser.getRole());
        }
        return response;
    }

    @GetMapping("/admin")
    public String admin(HttpSession session){

        if(session.getAttribute("isLoggedIn") == null){
            session.setAttribute("isLoggedIn", false);
        }

        boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");

        if(isLoggedIn == true){
            return "menuPages/admin";
        }else if(isLoggedIn == false){
            return "redirect:/error-page";
        }
        return "redirect:/";
    }
}
