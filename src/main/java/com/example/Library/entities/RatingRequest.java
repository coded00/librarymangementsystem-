package com.example.Library.entities;

public class RatingRequest {

    private String userName;
    private String bookname;
    private int rating;
    private String review;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
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

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "RatingRequest{" +
                "userName='" + userName + '\'' +
                ", bookname='" + bookname + '\'' +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
