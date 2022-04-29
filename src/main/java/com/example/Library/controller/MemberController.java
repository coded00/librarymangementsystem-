package com.example.Library.controller;

import com.example.Library.entities.Book;
import com.example.Library.entities.Member;
import com.example.Library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/add")
    public ResponseEntity<Member>addNewUsers(@RequestBody Member input){
        return new ResponseEntity<Member>(memberService.addnewUser(input), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Member>updatingUser(@RequestBody Member input){
        return new ResponseEntity<Member>(memberService.updateUsers(input),HttpStatus.ACCEPTED);
    }

    @GetMapping(value="getMember")
    public ResponseEntity<List<Member>>findByMail(@RequestBody Member input){
        return new ResponseEntity<List<Member>>(memberService.findByEmail(input),HttpStatus.FOUND);
    }

    @PutMapping(value = "/cart")
    public Member memberBooks (@RequestParam(value = "bookName") String bookname,
                                @RequestParam(value = "email")String email){
      return memberService.assignedBooks(bookname,email);
    }

    @DeleteMapping("/delete")
    public boolean deleteMember (@RequestBody Member input){
        memberService.deletebyId(input);
        return true;
    }
}
