package com.security.repository.mapper;

import java.sql.ResultSet;
import com.security.model.User;

import javax.swing.tree.RowMapper;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultset, int i) throws SQLException {
        User user = new User();
        user.setUsername(resultset.getString("username"));
        user.setPassword(resultset.getString("password"));
        return user;
    }
}
