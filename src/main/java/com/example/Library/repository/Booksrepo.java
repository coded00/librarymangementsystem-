package com.example.Library.repository;

import com.example.Library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Booksrepo extends JpaRepository<Book,Long> {

    List<Book>findByBooknameAndBookauthor(String bookname, String bookauthor);
    Book findByBookname(String bookname);
    List<Book> deleteByBookname(String bookname);
}
