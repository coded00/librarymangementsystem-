package com.example.Library.controller;

import com.example.Library.entities.Book;
import com.example.Library.entities.Member;
import com.example.Library.entities.Rating;
import com.example.Library.entities.RatingRequest;
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
    public ResponseEntity<Book> savebook(@RequestBody Book input) {
        return new ResponseEntity<Book>(booksservice.addnewbook(input), HttpStatus.CREATED);
    }

    @GetMapping("/get/books")
    public List<Book> getallbooks() {
        return booksservice.viewallbooks();
    }

    @GetMapping("/get/bookname")
    public ResponseEntity<List<Book>> findBookByBookname(@RequestBody Book input) {
        return new ResponseEntity<List<Book>>(booksservice.findByBookname(input), HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updatbooks(@RequestBody Book books) {
        return new ResponseEntity<Book>(booksservice.updatebooks(books), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public boolean deletebooks(@RequestBody Book input) {
        booksservice.deletebyid(input);
        return true;
    }

    @PostMapping("/rate")
    public Rating rateBook(@RequestBody RatingRequest request) {
        return booksservice.rateBook(request.getUserName(), request.getBookname(), request.getRating(), request.getReview());
    }

    @GetMapping("get/rate")
    public List<Rating> findrate(@RequestParam(name = "bookName") String bookName) {
        return booksservice.viewrate(bookName);
    }

    @PutMapping("/status")
    public ResponseEntity<Book> changeBookStatus(@RequestParam(name = "bookName") String bookname,
                                                 @RequestParam(name = "bookStatus") String status) {
        return new ResponseEntity<Book>(booksservice.changeBookStatus(bookname,status), HttpStatus.ACCEPTED);
    }

}
