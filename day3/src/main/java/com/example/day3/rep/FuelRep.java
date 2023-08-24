package com.example.day3.rep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day3.model.Petrolbunk;

public interface FuelRep extends JpaRepository<Petrolbunk,Integer> 
{

}
