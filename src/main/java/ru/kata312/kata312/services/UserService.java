package ru.kata312.kata312.services;

import org.springframework.stereotype.Service;
import ru.kata312.kata312.model.User;


import java.util.List;

@Service
public interface UserService {
    List<User> userAll();

    User userById(long id);

    void save(User user);

    void update(User userUpdate);

    void delete(long id);
}
