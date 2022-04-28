package com.example.Library.repository;

import com.example.Library.entities.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface ShelfRepository extends JpaRepository <Shelf,Long>{
}
