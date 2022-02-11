package com.security.repository.mapper;

import com.security.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultset, int i) throws SQLException {
        User user = new User();
        user.setUsername(resultset.getString("username"));
        user.setPassword(resultset.getString("password"));
        String bool_str = resultset.getString("enabled");
        boolean bool = bool_str.equals("1")?true:false;
        user.setEnabled(bool);
        return user;
    }
}
