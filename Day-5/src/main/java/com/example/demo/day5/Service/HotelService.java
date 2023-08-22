package com.example.demo.day5.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.day5.model.HotelModel;
import com.example.demo.day5.repository.HotelRepo;

@Service
public class HotelService
{
	@Autowired
	public HotelRepo hrepo;
	
	//post data
	public String saveHotel(HotelModel h)
	{
		hrepo.save(h);
		return "Data is saved to database.";
	}
	
//	
//	//get data
//	public List<HotelModel> getHotel()
//	{
//		return hrepo.findAll();
//	}
	
	
	//getUserByID

	  public Optional<HotelModel>getUserId(int userId)

	  {

		  Optional<HotelModel>hotel=hrepo.findById(userId);

		  if(hotel.isPresent())

		  {

			  return hotel;

		  }

		  return null;

	  }
	
	//update the data if id present

	  public boolean updateHotelif(int hotelId,HotelModel hm) {

		  if(hrepo.existsById(hotelId)) {

			  hrepo.save(hm);

			  return true;

		  }

		  return false;

	  }

	  
	
	
	//update data
	public HotelModel updateHotel(HotelModel hm)
	{
		return hrepo.saveAndFlush(hm);
	}
	  
	  
	  
	  
	//delete if id is present
	public boolean deleteHotelif(int hotelId)
	{
		if(hrepo.existsById(hotelId))
		{
			hrepo.deleteById(hotelId);
			return true;
		}
		return false;
	}
	
	
	//delete data
	public void deleteHotel(int hotel_id)
	{
		System.out.println("Deleted");
		hrepo.deleteById(hotel_id);
		
	}
}