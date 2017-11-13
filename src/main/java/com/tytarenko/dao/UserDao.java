package com.tytarenko.dao;

import com.tytarenko.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User getById(int id);

    User getByLogin(String login);

    List<User> findAll();

    void update(User user);

    void delete(int id);

}
