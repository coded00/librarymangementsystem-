package com.example.Library.repository;

import com.example.Library.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Booksrepo extends JpaRepository<Books,Long> {
    List<Books> findByBookname(String bookname);
    List<Books> deleteByBookname(String bookname);
}
