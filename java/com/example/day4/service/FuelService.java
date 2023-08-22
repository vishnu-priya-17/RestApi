package com.example.day4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day4.petrol.PetrolBunk;
import com.example.day4.repositary.FuelRep;

@Service
public class FuelService {
	@Autowired
	public FuelRep frepo;
	
	public PetrolBunk saveDetails(PetrolBunk p)
	{
		return frepo.save(p);
	}
	
	public List<PetrolBunk> getDetails()
	{
		return frepo.findAll();
	}
	
}
