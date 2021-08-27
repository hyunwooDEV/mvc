package com.example.mvc.Controller;

import com.example.mvc.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path ="/hello") // http://localhost:8080/api/get/hello
    public String hello(){
        return "get Hello";
    }
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get http:localhost:8080/api/get/hi
    public String hi() {
        return "hi";
    }

    //http:localhost:8080/api/get/path-variable/{name}

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable : " + name);
        return name;
    }

    //매개변수명을 통일시켜야하나, 외로 아래와 같이 다른 매개변수를 받아 name에 지정할 수 있다
    @GetMapping("/path-another-variable/{name}")
    public String anotherPathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("anotherPathVariable : " + pathName);
        return pathName;
    }

    //  http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30

    @GetMapping(path ="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {


        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach( entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email+" "+age;
    }

    //?user=steve&email=steve@gmail.com&age=32
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }





}

