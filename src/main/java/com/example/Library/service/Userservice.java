package com.example.Library.service;

import com.example.Library.entities.Users;
import com.example.Library.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {

    @Autowired
    private Userrepo userrepo;


    public Users addnewUser (Users input){
        String existingUser = input.getEmail();
       if(existingUser != null){
         throw new RuntimeException("This mail exist");
       }
       return userrepo.save(input);
    }


    public Users updateUsers (Users input){
        String existingUser = input.getEmail();
        if(existingUser == null ){
            throw new RuntimeException("Theres nothing to update");
        }
        return userrepo.save(input);
    }

    public List<Users>findByEmail(Users input){
        String existingUser = input.getEmail();
        return userrepo.findByEmail(existingUser);
   }
}
