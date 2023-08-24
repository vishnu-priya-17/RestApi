package com.example.day3.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.day3.model.Petrolbunk;
import com.example.day3.rep.FuelRep;

@Service
public class FuelService {
	@Autowired
	public FuelRep frepo;
	//post the data
	public Petrolbunk saveDetails(Petrolbunk p)
	{
		return frepo.save(p);
	}
	//get the data
	public List<Petrolbunk> getDetails()
	{
		return frepo.findAll();
	}
}
