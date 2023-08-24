package com.example.day3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day3.model.Petrolbunk;
import com.example.day3.service.FuelService;

@RestController
public class Fuelcontroller {
     @Autowired
     FuelService fser;
     @PostMapping("/savefuel")
     public Petrolbunk saveFuelStationDe(@RequestBody Petrolbunk pb)
     {
    	 return fser.saveDetails(pb);
     }
     @GetMapping("/getfuel")
     public List<Petrolbunk> getFuelStationDe()
     {
    	 return fser.getDetails();
     }

}
