package com.example.demo.day5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.day5.model.HotelModel;
import com.example.demo.day5.Service.HotelService;

@RestController
public class HotelController
{
	@Autowired
	public HotelService hserv;
	@PostMapping("/PostHotel")
	public String postHotel(@RequestBody HotelModel hr)
	{
		hserv.saveHotel(hr);
		return "data saved";
	}
	
	
//	//get mapping
//	@GetMapping("/getHotel")
//	public List<HotelModel> getHotelInfo()
//	{
//		return hserv.getHotel();
//		
//	}
	
	//getUserByID

    @GetMapping("/users/{userId}")

    public ResponseEntity<?> getUserById(@PathVariable int userId){

    	Optional<HotelModel>hotel=hserv.getUserId(userId);

    	

    	if(hotel!=null)

    	{

    		return ResponseEntity.ok(hotel); //Return the user's data if available

    	}

    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");

    }
	
	
	
	//put mapping
//	@PutMapping("/updateModel")
//	public HotelModel updateHotelInfo(@RequestBody HotelModel h)
//	{
//		return hserv.updateHotel(h);
//	}
    
    
    @PutMapping("/updateHotel")

    public HotelModel updateHotelInfo(@RequestBody HotelModel ha)

    {

    	return hserv.updateHotel(ha);

    }

    @PutMapping("/updateHotelif/{id}")

    public ResponseEntity<String> updateHotelInfor(@PathVariable int id,@RequestBody HotelModel ha){

    	   boolean updated=hserv.updateHotelif(id,ha);

 			   if(updated)

 			   {

 				  return ResponseEntity.ok("Hotel with ID "+id+" updated successfully"); //.ok means sucess

 			   }

 			   else

 			   {

 				  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+id+" not found and not updated");

 			   }

 	   }


	
	
	//delete mapping using pathvariable
//	@DeleteMapping("/deleteHotel/{id}")
//	public String removeHotel(@PathVariable("id") int hid)
//	{
//		hserv.deleteHotel(hid);
//		return "Hotel with Id "+hid+" is deleted";
//	}
	
	
//	
//	//delete mapping using reqparam
//	@DeleteMapping("/byReqParm")
//	public String removeRequestPam(@RequestParam("id")int id)
//	{
//		hserv.deleteHotel(id);
//		return "Hotel with Id "+id+" is deleted";
//	}
	
	
	
	//delete using if condition
	@DeleteMapping("/deleteHotelif/{id}")
	public ResponseEntity<String>deleteHotelInfo(@PathVariable int id)
	{
		boolean deleted=hserv.deleteHotelif(id);
		if(deleted)
		{
			return ResponseEntity.ok("Hotel with ID "+id+" deleted successfully");
			
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+id+" not found");
		}
			
		
	}
	
}