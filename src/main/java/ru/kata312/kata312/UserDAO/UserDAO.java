package ru.kata312.kata312.UserDAO;

import org.springframework.stereotype.Repository;
import ru.kata312.kata312.model.User;


import java.util.List;
@Repository
public interface UserDAO {
    List<User> findAll();

    User findById(long id);

    void save(User user);

    void update(User user);

    void deleteById(long id);
}
