package com.example.Library.entities;

import javax.persistence.*;

@Entity
@Table(name ="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String bookdetails;
}
