package com.tytarenko.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * POJO that represents a User.
 *
 * @author Vladyslav Tytarenko
 * @version 1.0
 */

public class User {

    @NotNull
    private long id;

    @Size(min = 3, max = 15, message = "login")
    private String login;

    @Size(min = 6, max = 20, message = "password")
    private String password;

    //@Pattern([])
    private String email;

    @Min(14)
    private int age;

    @NotNull(message = "user type")
    private UserType userType;

    public User() {
    }

    public User(long id, String login, String password, String email, int age, UserType userType) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}