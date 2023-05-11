package com.rohan.springboot.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/hello-world-internationalized")
    public String helloInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource
                .getMessage("good.morning.message", null,"Default message", locale);
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
