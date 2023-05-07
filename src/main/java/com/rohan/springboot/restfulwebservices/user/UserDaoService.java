package com.rohan.springboot.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Rohan", LocalDate.now().minusYears(29)));
        users.add(new User(2,"Riddhi", LocalDate.now().minusYears(28)));
    }

    public List<User> users() {
        return users;
    }

    public User findOne(Integer id) throws Exception {
        return users.stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow(Exception::new);
    }
}
