package com.example.demo.utility;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.stream.Collectors;


public class SQLUtility {
    private SQLUtility(){

    }
    public static String getSqlQuery(String classpathFile) throws SQLException {
        try(InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(classpathFile)){
            try(InputStreamReader isr = new InputStreamReader(is); BufferedReader reader = new BufferedReader(isr)){
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }

        }
        catch(IOException io){
            throw new SQLException("Failed to Read the SQL Query File from resource"+ io.getMessage());
        }
    }

}
