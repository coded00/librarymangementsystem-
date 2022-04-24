package com.example.Library.service;

import com.example.Library.entities.Books;
import com.example.Library.repository.Booksrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Booksservice {

    @Autowired
    public Booksrepo  booksrepo;


    public Books addnewbook (Books books){
        return booksrepo.save(books);
    }

    public List<Books>viewallbooks(){
        return booksrepo.findAll();
    }

    public Books updatebooks(Books books){ return booksrepo.save(books);}

    public List<Books>findByBookname(Books input){
        String existingbook = input.getBookname();
        return booksrepo.findByBookname(existingbook);
    }
    public boolean deletebyid (Books input){
        String existingbooks = input.getBookname();
        long idNum = input .getId();
        booksrepo.deleteById(idNum);
        return true;
    }


    }


