package com.example.day6.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.day6.Model.Shop;

import jakarta.transaction.Transactional;

public interface Shoprepo extends JpaRepository<Shop,Integer> 
{
	@Query(value="select * from shop", nativeQuery = true) 
	public List<Shop> getAllRows(); 
	@Query(value="select * from shop where id=:id and product_name=:name",nativeQuery = true )
	public List<Shop> getSpecRows(@Param("id") int id,@Param("name") String name);
	@Query(value="select * from shop where id between :id1 and :id2",nativeQuery = true )
	public List<Shop> get(@Param("id1") int id1,@Param("id2") int id2);
	@Query(value="select s from Shop s where s.brandName like %?1%")
	public List<Shop> getb(@Param("name") String name);
	@Query(value="select * from shop where product_name is not null",nativeQuery = true)
	public List<Shop> getn(@Param("name") String name);
	
@Modifying
@Transactional
@Query(value="delete from shop where id=:id",nativeQuery = true)
public int deleterowbyid(@Param("id") int id);
	
@Modifying
@Transactional
	@Query(value="update shop set product_name=:name where id=:id",nativeQuery = true)
	public Integer update(@Param("name") String name,@Param("id") int id);

}
