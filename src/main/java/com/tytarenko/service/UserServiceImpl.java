package com.tytarenko.service;

import com.tytarenko.dao.UserDao;
import com.tytarenko.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }

    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void update(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.update(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

}