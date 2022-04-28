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
       return memberRepository.save(input);
    }


    public Member updateUsers (Member input){
        return memberRepository.save(input);
    }

    public List<Member>findByEmail(Member input){
        String existingUser = input.getEmail();
        return memberRepository.findMembersByEmail(existingUser);
   }

    public boolean deletebyId (Member input){
        String existingMember = input.getUserName();
        long idNum = input.getId();
        memberRepository.deleteById(idNum);
        return true;
    }

   public Member assignedBooks (String bookname , String email){
       Member member =  memberRepository.findByEmail(email);
       Book book = booksrepo.findByBookname(bookname);
       member.getBooks().add(book);
       return memberRepository.save(member);
   }
}
