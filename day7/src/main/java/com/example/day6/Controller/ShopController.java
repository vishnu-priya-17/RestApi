package com.example.day6.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6.Model.Shop;
import com.example.day6.Service.ShopService;

@RestController
public class ShopController {
	@Autowired
	ShopService sserv;
	
	@GetMapping("/getAllrows") 
	public List<Shop> getallRows() 
	{ 
		return sserv.getAllrows(); 
	} 
	//get specific data 
	@GetMapping("/getSpecific/{id}/{name}") 
	public List<Shop> getSpec(@PathVariable("id") int id,@PathVariable("name") String name) 
	{ 
		return sserv.getSpecrows(id, name); 
	}
	@GetMapping("/getBet/{id1}/{id2}") 
	public List<Shop> getBet(@PathVariable("id1") int id1,@PathVariable("id2") int id2) 
	{ 
		return sserv.getbet(id1, id2); 
	}
	@GetMapping("/getBrand/{name}") 
	public List<Shop> getBrand(@PathVariable("name") String name) 
	{ 
		return sserv.getbrand(name); 
	}
	@GetMapping("/getNull/{name}") 
	public List<Shop> getNull(@PathVariable("name") String name) 
	{ 
		return sserv.getnul(name); 
	}
	@DeleteMapping("/deleterow/{id}")
	public String deleteRow(@PathVariable("id") int id)
	{
		return sserv.delete(id)+" deleted";
	}
	@PutMapping("/updateid/{add}/{id}")
	public String updateInfo(@PathVariable("add") String name,@PathVariable("id") int id)
	{
		return sserv.updaterow(name,id)+" row updated";
    }        
}
