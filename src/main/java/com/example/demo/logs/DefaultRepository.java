package com.example.demo.logs;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DefaultRepository {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    DefaultRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}
