package com.rohan.springboot.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    public UserResource(UserDaoService service) {
        this.userDaoService = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.users();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable Integer id) {
        User user = userDaoService.findOne(id);
        EntityModel<User> userEntityModel = EntityModel.of(user);

        WebMvcLinkBuilder link =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        userEntityModel.add(link.withRel("all-users"));
        return userEntityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
        //return userDaoService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        User deletedUser = userDaoService.deleteById(id);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }
}
