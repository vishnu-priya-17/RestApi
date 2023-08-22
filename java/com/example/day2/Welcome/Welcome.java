package com.example.day2.Welcome;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Welcome
{
	@Value("Welcome to SpringBoot!")
	public String name;
	
	@RequestMapping("/welcome")
	public String display()
	{
		return name;
	}
	
}