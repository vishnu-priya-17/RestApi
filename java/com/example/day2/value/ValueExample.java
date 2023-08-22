package com.example.day2.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ValueExample
{
	@Value("161")
	public int regNum;
	@Value("Sus")
	public String name;
	
	@RequestMapping("/display")
	public String display()
	{
		return "My name is "+name+" Reg naumber is"+regNum;
	}
	
}