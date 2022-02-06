package com.security.repository;

import com.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void addSave(User addUser){
        String sql = "INSERT INTO user(username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, addUser.getUsername(), addUser.getPassword());
    }
}
