package com.rohan.springboot.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount,"Rohan", LocalDate.now().minusYears(29)));
        users.add(new User(++userCount,"Riddhi", LocalDate.now().minusYears(28)));
    }

    public List<User> users() {
        return users;
    }

    public User findOne(Integer id) {
        return users.stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User deleteById(Integer id) {
        User user = users.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        users.remove(user);
        return user;
    }
}
