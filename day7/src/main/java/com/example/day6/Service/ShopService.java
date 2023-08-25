package com.example.day6.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day6.Model.Shop;
import com.example.day6.Repository.Shoprepo;

@Service
public class ShopService {
	@Autowired
	Shoprepo srepo;
	//get all the data 1                                             
	public List<Shop> getAllrows() 
	{ 
		return srepo.getAllRows(); 
	} 
	//get specific rows 
	public List<Shop> getSpecrows(int id,String name) 
	{ 
		return srepo.getSpecRows(id, name); 
	}
	//get specific rows 
		public List<Shop> getbet(int id1,int id2) 
		{ 
			return srepo.get(id1, id2); 
		}
		public List<Shop> getbrand(String name) 
		{ 
			return srepo.getb(name); 
		}
		public List<Shop> getnul(String name) 
		{ 
			return srepo.getn(name); 
		}
	public int delete(int id) 
	{ 
		return srepo.deleterowbyid(id); 
	}
	public Integer updaterow(String name,int id)
	{
		return srepo.update(name,id);
	}
}
