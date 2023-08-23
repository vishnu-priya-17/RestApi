package com.project.shop.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.project.shop.model.Shop;
import com.project.shop.service.ShopService;

@RestController
public class ShopController {
	@Autowired
    ShopService sser;
    @PostMapping("/savedetails")
    public Shop saveDetails(@RequestBody Shop pb)
    {
    	return sser.savedetails(pb);
    }
    @GetMapping("/getdetails")
    public List<Shop> getDetails()
    {
    	return sser.getdetails();
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
    	Optional<Shop> item=sser.getbyid(id);
    	if(item!=null)
    	{
    		return ResponseEntity.ok(item);
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID is not available");
    }
    @PutMapping("/updatebyid/{id}")
    public ResponseEntity<String> updateById(@PathVariable int id,@RequestBody Shop sh){
    	boolean updated=sser.updatebyid(id,sh);
    	if(updated)
    	{
    		return ResponseEntity.ok("Updated successfully");
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
    	}
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDetails(@PathVariable("id") int id)
    {
    	boolean deleted=sser.delete(id);
    	if(deleted)
    	{
    		return ResponseEntity.ok("Deleted successfully");
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
    	}
    }
}
