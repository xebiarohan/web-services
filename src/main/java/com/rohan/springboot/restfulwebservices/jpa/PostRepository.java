package com.rohan.springboot.restfulwebservices.jpa;

import com.rohan.springboot.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
