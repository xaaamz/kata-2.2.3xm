package ru.kata312.kata312.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata312.kata312.UserDAO.UserDAO;
import ru.kata312.kata312.model.User;



import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;


    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;

    }

    public List<User> userAll() {
        return userDAO.findAll();
    }

    public User userById(long id) {
        Optional<User> userFound = Optional.ofNullable(userDAO.findById(id));
        return userFound.orElse(null);
    }
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void update(User userUpdate) {
        userDAO.update(userUpdate);
    }

    @Transactional
    public void delete(long id) {
        userDAO.deleteById(id);
    }
}
