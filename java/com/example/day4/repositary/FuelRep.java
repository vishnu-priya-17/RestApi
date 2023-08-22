package com.example.day4.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day4.petrol.PetrolBunk;

public interface FuelRep extends JpaRepository<PetrolBunk,Integer>{

}
