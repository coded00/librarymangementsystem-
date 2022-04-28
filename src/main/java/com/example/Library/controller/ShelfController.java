package com.example.Library.controller;


import com.example.Library.entities.Shelf;
import com.example.Library.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.awt.*;

@RestController
@RequestMapping("/shelf")
public class ShelfController {

    @Autowired
    private ShelfService shelfService;

    @PostMapping("/add")
    public ResponseEntity<Shelf>addNewShelf(@RequestBody Shelf input){
       return  new ResponseEntity<Shelf>(shelfService.addNewShelf(input),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Shelf>updateShelf(@RequestBody Shelf input){
        return  new ResponseEntity<Shelf>(shelfService.updateshelf(input),HttpStatus.ACCEPTED);
    }
}
