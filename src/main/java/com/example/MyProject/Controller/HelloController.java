package com.example.MyProject.Controller;

import org.springframework.web.bind.annotation.*;

@RestController  //Controller + response body
public class HelloController {

@GetMapping("/hello")  //http get request + URL
    public String Hello(){
    return  "Hello I want to learn Spring Boot";
}

@GetMapping("/Sum/{a}/{b}")
    public int Sum(@PathVariable int a, @PathVariable int b){ //fetching data from the URL @PathVariable
    return a+b;
}

@GetMapping ("/greet")
    public String greet(@RequestParam String Name){  // Query param  /greet?name=Anand
    return "Hello " + Name;  //o/p Hello Anand
}

@PostMapping ("/welcome")  //post test using Postman
    public String welcome(){
    return "Welcome to spring boot";
}
}
