package com.coforge.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void createUser(String username, String email) {
        String insertUserSQL = "INSERT INTO users (username, email) VALUES (?, ?)";
        jdbcTemplate.update(insertUserSQL, username, email);

       
        if (username.equals("error")) {
            throw new RuntimeException("Simulated Error: Rollback transaction");
        }
    }
}
