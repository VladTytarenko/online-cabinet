package com.tytarenko.mapper;


import com.tytarenko.entity.User;
import com.tytarenko.entity.UserType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setEmail(resultSet.getString("email"));
        user.setLogin(resultSet.getString("login"));
        user.setLogin(resultSet.getString("password"));
        user.setAge(resultSet.getInt("age"));
        user.setUserType(UserType.valueOf(resultSet.getString("user_type")));
        return user;
    }
}
