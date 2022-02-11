package com.security.repository;

import com.security.model.User;
import com.security.repository.mapper.TokenMapper;
import com.security.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MyRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void addSave(User addUser) {

        String sql = "INSERT INTO user (username, password, enabled, created, token, expiryDate) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, addUser.getUsername(), addUser.getPassword(), addUser.getEnabled().toString(),
                new Date(), addUser.getToken(), addUser.getExpiryDate());
    }

    public User getUserByToken(String token) {
        String sql = "SELECT * FROM user WHERE token=?";
        return jdbcTemplate.queryForObject(sql, new TokenMapper(), token);
    }

    public void update(User user) {
        String sql = "UPDATE user SET enabled=? WHERE username=?";
        jdbcTemplate.update(sql, user.getEnabled().toString(), user.getUsername());
    }

    public User getByUsername(String username){
        String sql = "SELECT * FROM user WHERE username=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
    }
}
