package com.example.MyProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.MyProject.Service.CalculateMultiply;

@RestController
public class MultiplyController {

    @Autowired
    private CalculateMultiply calculateMultiply;
    @GetMapping ("/multiply/{a}/{b}")

    public  int multiply(@PathVariable int a ,@PathVariable int b){
        return calculateMultiply.multiply(a,b) ;
    }
}
