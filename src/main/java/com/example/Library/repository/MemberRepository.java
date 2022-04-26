package com.example.Library.repository;

import com.example.Library.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findMembersByEmail(String email);
    Member findByEmail(String email);
}
