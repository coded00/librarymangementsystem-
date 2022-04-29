package com.example.Library.service;


import com.example.Library.entities.Shelf;
import com.example.Library.repository.ShelfRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShelfService {

    Logger log = LoggerFactory.getLogger(ShelfService.class);

    @Autowired
    private ShelfRepository shelfRepository;

   public Shelf addNewShelf (Shelf input ){
     return shelfRepository.save(input);
   }

   public Shelf updateshelf ( Shelf input ){
       return shelfRepository.save(input);
   }

   public boolean deleteById(Shelf input){
       String existingShelf = input.getShelfName();
       Long idNum = input.getShelfId();
       shelfRepository.deleteById(idNum);
       return true;
   }
}
