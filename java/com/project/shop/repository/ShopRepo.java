package com.project.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shop.model.Shop;

public interface ShopRepo extends JpaRepository<Shop,Integer> {

}
