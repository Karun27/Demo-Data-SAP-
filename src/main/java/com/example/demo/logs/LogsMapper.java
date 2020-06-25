package com.example.demo.logs;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogsMapper implements RowMapper<Logs> {
    @Override
    public Logs mapRow(ResultSet resultSet, int i) throws SQLException {
        Logs logs = new Logs();
        logs.setDate(resultSet.getDate("DATED"));;
        logs.setInstance_id(resultSet.getString("INSTANCE_ID"));
        logs.setJob_Name(resultSet.getString("JOB_NAME"));
        logs.setJob_Id(resultSet.getString("JOB_ID"));
        logs.setMessage(resultSet.getString("MESSAGE"));
        return logs;
    }
}
