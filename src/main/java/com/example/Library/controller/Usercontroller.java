package com.example.Library.controller;

import com.example.Library.entities.Users;
import com.example.Library.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class Usercontroller {

    @Autowired
    private Userservice userservice;

    @PostMapping(value = "adduser")
    public ResponseEntity<Users>addNewUsers(@RequestBody Users input){
        return new ResponseEntity<Users>(userservice.addnewUser(input), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Users>updatinguser(@RequestBody Users input){
        return new ResponseEntity<Users>(userservice.updateUsers(input),HttpStatus.ACCEPTED);
    }

    @GetMapping(value="getUser")
    public ResponseEntity<List<Users>>findByMail(@RequestBody Users input){
        return new ResponseEntity<List<Users>>(userservice.findByEmail(input),HttpStatus.FOUND);
    }
}
