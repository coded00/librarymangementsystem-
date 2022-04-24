package com.example.Library.repository;

import com.example.Library.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Userrepo extends JpaRepository<Users,Long> {
    List<Users> findByEmail(String email);
}
