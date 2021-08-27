package com.example.mvc.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class 는 REST API를 처리하는 Controller
@RequestMapping("/api") // RequestMapping URI를 지정해주는 Annotiation
public class ApiController {

    @GetMapping("/hello") //http://localhost:8080/api/hello
    public String hello() {
        return "hello spring boot!";

    }



}
