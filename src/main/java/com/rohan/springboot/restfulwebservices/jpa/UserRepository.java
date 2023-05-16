package com.rohan.springboot.restfulwebservices.jpa;

import com.rohan.springboot.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
