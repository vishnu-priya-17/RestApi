package com.example.demo.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
 public class ValueExamplle1
 {
	@Value(value="${age:18}")
	public int  age;
	@Value(value="${myName}")
	public String name;
	
	@GetMapping("/dis")
	public String dis()
	{
		return "My name is "+name+".My age is "+age;
	}
	
 }