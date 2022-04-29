package com.example.Library.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="rating")
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private int rating;

    @Column(columnDefinition = "text")
    private String review;

    @ManyToOne
    @JoinColumn(name = "bookname", referencedColumnName = "bookName")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "userName")
    private Member member;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
      this.book = book;
    }


    public void setReview(String review) {
        this.review = review;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "Id=" + Id +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                ", book=" + book +
                ", member=" + member +
                '}';
    }
}
