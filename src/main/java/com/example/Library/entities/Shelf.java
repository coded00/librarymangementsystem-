package com.example.Library.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="shelf")
public class Shelf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shelfId;

    @Column
    private String shelfName;

    @Column
    private String category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> bookList = new ArrayList<>();

    public Long getShelfId() {
        return shelfId;
    }

    public void setShelfId(Long shelfId) {
        this.shelfId = shelfId;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category){
      this.category = category;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "shelfId=" + shelfId +
                ", shelfName='" + shelfName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
