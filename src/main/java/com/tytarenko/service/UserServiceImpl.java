package com.tytarenko.service;

import com.tytarenko.dao.UserDao;
import com.tytarenko.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // бізнес логіка, наприклад: валідація, перевірки і т.д.
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;
    //можливо додатково робить autowired іншого сервісу

    public void save(User user) throws Exception {
        if (user.getName().length() < 2)
            throw new Exception();

        userDao.save(user);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }
}