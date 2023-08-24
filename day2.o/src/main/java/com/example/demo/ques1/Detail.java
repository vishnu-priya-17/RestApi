package com.example.demo.ques1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Detail {
@Value("${var}")
private String name;
@GetMapping("/name")
public String open() {
return "Hi Everyone!!.I am "+name;
}

}
