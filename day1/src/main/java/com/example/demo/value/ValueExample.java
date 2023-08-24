package com.example.demo.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueExample
{
	@Value("sandy")
	public String name;
	
	@RequestMapping("/display")
	public String display()
	{
		return "My name is "+name;
	}
	
}