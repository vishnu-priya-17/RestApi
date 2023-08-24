package com.example.demo.qn2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Name
{
	  @GetMapping("/name")
       public String getname()
       {
    	   String name="Hi I am Sandhiya";
    	   return name;
       }         
}
