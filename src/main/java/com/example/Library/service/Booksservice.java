package com.example.Library.service;

import com.example.Library.entities.Book;
import com.example.Library.repository.Booksrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Booksservice {

    @Autowired
    public Booksrepo  booksrepo;


    public Book addnewbook (Book books){
        return booksrepo.save(books);
    }

    public List<Book>viewallbooks(){
        return booksrepo.findAll();
    }

    public Book updatebooks(Book books){ return booksrepo.save(books);}

   public List<Book>findByBookname(Book input){
      String existingBook = input.getBookname();
      String existingAuthor = input.getBookauthor()
;      return booksrepo.findByBooknameAndBookauthor(existingBook,existingAuthor);
 }
    public boolean deletebyid (Book input){
        String existingbooks = input.getBookname();
        long idNum = input .getBookid();
        booksrepo.deleteById(idNum);
        return true;
    }





    }


