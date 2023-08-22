package com.example.day5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.day5.model.Book;
import com.example.day5.repositories.BookRepo;

@Service
public class ApiService
{
    @Autowired
public BookRepo b;
    public Book savedetails(Book bo)
    {
    return b.save(bo);
    }
    public List<Book> getDetails()
{
return b.findAll();
}
    public Optional<Book>getUserId(int userId)

    {

   Optional<Book> note=b.findById(userId);

   if(note.isPresent())

   {

   return note;

   }

   return null;

    }
    public Book updatedetails(Book bo)
    {
    return b.saveAndFlush(bo);
    }
    public boolean updatebook(int id,Book bo) {
   if(b.existsById(id)) {
   b.save(bo);
   return true;
   }
   return false;
    }
    public Book updatedetails1(Book bo)
    {
    return b.save(bo);
    }
    public void deletebook1(int bo)
    {
    System.out.print("Deleted Successfully");
    b.deleteById(bo);
    }
    public void deletebook2(int bo)
    {
    b.deleteById(bo);
    }
    public boolean deletebook3(int id)
    {
    if(b.existsById(id))
    {
    b.deleteById(id);
    return true;
    }
    return false;
    }

}

