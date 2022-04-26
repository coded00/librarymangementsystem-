package com.example.Library.service;

import com.example.Library.entities.Book;
import com.example.Library.entities.Member;
import com.example.Library.repository.Booksrepo;
import com.example.Library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private Booksrepo booksrepo;


    public Member addnewUser (Member input){
        String existingUser = input.getEmail();

       return memberRepository.save(input);
    }


    public Member updateUsers (Member input){
        String existingUser = input.getEmail();
        if(existingUser == null ){
            throw new RuntimeException("Theres nothing to update");
        }
        return memberRepository.save(input);
    }

    public List<Member>findByEmail(Member input){
        String existingUser = input.getEmail();
        return memberRepository.findMembersByEmail(existingUser);
   }

   public Member assignedBooks(String bookname, String email){
       Member member =  memberRepository.findByEmail(email);
       Book book = booksrepo.findByBookname(bookname);
       member.getBooks().add(book);
       return member;
   }
}
