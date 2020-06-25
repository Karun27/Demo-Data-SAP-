package com.example.demo.logs;

import com.example.demo.utility.SQLUtility;

import java.sql.SQLException;

import static com.example.demo.utility.SQLUtility.getSqlQuery;

public final class LogsConstants {
    public static final String INSTANCE_ID = "INSTANCE_ID";
    public static  String query;

    private LogsConstants() {
    }

    static {
        try {
            query = SQLUtility.getSqlQuery("sql/getLoadLogs.sql");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
