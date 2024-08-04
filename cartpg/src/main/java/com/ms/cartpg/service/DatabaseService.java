package com.ms.cartpg.service;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void callCreateAndCopyDataRemote() {
        jdbcTemplate.execute("CALL pg.create_and_copy_data_remote();");
    }
}
