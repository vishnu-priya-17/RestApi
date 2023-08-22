package com.example.day5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day5.model.Book;
import com.example.day5.service.ApiService;

@RestController
public class ApiController {
	@Autowired
    ApiService fser;
    @PostMapping("/save")
    public Book saveBooksDetails(@RequestBody Book pb)
    {
    return fser.savedetails(pb);
    }
    @GetMapping("/get")
    public List<Book> getbook()
    {
    return fser.getDetails();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int userId){
    Optional<Book> ot=fser.getUserId(userId);
    if(ot!=null)
    {
    return ResponseEntity.ok(ot);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
    }
   
    @PutMapping("/put")
    public Book updateBooksDetails(@RequestBody Book pb)
    {
    return fser.updatedetails(pb);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id,@RequestBody Book bo){
      boolean updated=fser.updatebook(id,bo);
    if(updated)
    {
   return ResponseEntity.ok("Book updated successfully");
    }
    else
    {
   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
    }
    }
    @DeleteMapping("/delete/{id}")
    public String removebook1(@PathVariable("id") int bid)
    {
    fser.deletebook1(bid);
    return "Book is deleted";
    }
    @DeleteMapping("/deletebyparam")
    public String removebook2(@RequestParam("id") int id)
    {
    fser.deletebook2(id);
    return "Book is deleted successfully";
    }
    @DeleteMapping("/delete1/{id}")
    public ResponseEntity<String> removebook3(@PathVariable("id") int bi)
    {
    boolean deleted=fser.deletebook3(bi);
    if(deleted)
    {
    return ResponseEntity.ok("Book is deleted");
    }
    else
    {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("data is not found");
    }
    }
}
