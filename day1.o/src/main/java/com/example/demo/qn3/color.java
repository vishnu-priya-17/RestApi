package com.example.demo.qn3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class color 
{
	   @GetMapping("/color")
       public String favColor()
       {
    	   String colour ="Black";
    	   return "My Favorite Color is "+colour;
       }
}