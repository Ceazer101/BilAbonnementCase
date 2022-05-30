package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Role;
import com.example.bilabonnementcase.models.User;
import java.util.ArrayList;
import java.util.Arrays;

//Author: Chris, Maja, Güler, Kenn
public class DummyUserRepo  {

    ArrayList<User> userList = new ArrayList<User>(
            Arrays.asList(
                    new User("maja", "hej", Role.DAMAGEREGISTRATOR),
                    new User("chris", "hejhej", Role.DAMAGEREGISTRATOR),
                    new User("güler", "hallo", Role.NOROLE)
            )
    );

    public boolean validateLoginInformation(User user){
        for(User u : userList){
            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }


}
