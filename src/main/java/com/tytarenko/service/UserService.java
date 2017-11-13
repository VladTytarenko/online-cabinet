package com.tytarenko.service;

import com.tytarenko.entity.User;

import java.util.List;

public interface UserService {

    void save(User user) throws Exception;

    User getById(int id);

    User getByLogin(String login);

    List<User> findAll();

    void update(User user);

    void delete(int id);

}
