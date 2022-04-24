package com.example.Library.controller;

import com.example.Library.entities.Books;
import com.example.Library.service.Booksservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class Bookscontroller {

    @Autowired
    private Booksservice booksservice;

    @PostMapping("/add")
    public ResponseEntity<Books>savebook(@RequestBody Books input){
        return new ResponseEntity<Books>(booksservice.addnewbook(input), HttpStatus.CREATED);
    }

    @GetMapping("/get/books")
    public List <Books> getallbooks(){
        return booksservice.viewallbooks();
    }

    @GetMapping("/get/bookname")
    public ResponseEntity<List<Books>>findBookByBookname(@RequestBody Books input){
        return new ResponseEntity<List<Books>>(booksservice.findByBookname(input),HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Books>updatbooks(@RequestBody Books books){
        return new ResponseEntity<Books>(booksservice.updatebooks(books), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public boolean deletebooks (@RequestBody Books input){
        booksservice.deletebyid(input);
        return true;
    }


}
