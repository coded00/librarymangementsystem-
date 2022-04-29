package com.example.Library.service;

import com.example.Library.entities.Book;
import com.example.Library.entities.Member;
import com.example.Library.entities.Rating;
import com.example.Library.entities.Shelf;
import com.example.Library.repository.Booksrepo;
import com.example.Library.repository.MemberRepository;
import com.example.Library.repository.RatingRepository;
import com.example.Library.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Booksservice {

    @Autowired
    public Booksrepo  booksrepo;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private MemberRepository memberRepository;

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

    public Rating rateBook (String userName , String bookname, int rating , String review){
        Member member = memberRepository.findByUserName(userName);
        Book book = booksrepo.findByBookname(bookname);
        Rating rate = new Rating();
        rate.setRating(rating);
        rate.setBook(book);
        rate.setMember(member);
        rate.setReview(review);
        return ratingRepository.save(rate);

    }







    }


