package com.rohan.springboot.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorldBean helloX(@PathVariable String name) {
        return new HelloWorldBean("Hello " + name);
    }
}
