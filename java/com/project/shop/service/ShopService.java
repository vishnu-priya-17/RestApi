package com.project.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.shop.model.Shop;
import com.project.shop.repository.ShopRepo;

@Service
public class ShopService {
	 @Autowired
	 public ShopRepo srepo;
	 public Shop savedetails(Shop sh)
	 {
	     return srepo.save(sh);
	 }
	 public List<Shop> getdetails()
	 {
		 return srepo.findAll();
	 }
	 public Optional<Shop>getbyid(int id)
	 {
	    Optional<Shop> item=srepo.findById(id);
	    if(item.isPresent())
	    {
	    	return item;
	    }
	    return null;
	 }
	 public boolean updatebyid(int id,Shop sh) {
	    if(srepo.existsById(id)) {
	    	srepo.save(sh);
	    	return true;
	    }
	    return false;
	  }
	  public boolean delete(int id)
	  {
	     if(srepo.existsById(id))
	     {
	    	 srepo.deleteById(id);
	    	 return true;
	     }
	     return false;
	  }
}
