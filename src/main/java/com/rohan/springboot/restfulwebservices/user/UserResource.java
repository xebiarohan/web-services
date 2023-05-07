package com.rohan.springboot.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    public UserResource(UserDaoService service) {
        this.userDaoService = service;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userDaoService.users();
    }

    @GetMapping("/users/{id}")
    public User getUsers(@PathVariable Integer id) throws Exception {
        return userDaoService.findOne(id);
    }
}
