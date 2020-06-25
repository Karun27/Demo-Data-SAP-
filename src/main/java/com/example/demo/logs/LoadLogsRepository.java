package com.example.demo.logs;

import com.example.demo.utility.SQLUtility;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

import static com.example.demo.logs.LogsConstants.INSTANCE_ID;
import static com.example.demo.utility.SQLUtility.getSqlQuery;

@Repository
public class LoadLogsRepository extends DefaultRepository {

    public LoadLogsRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(namedParameterJdbcTemplate);
    }

    public List<Logs> loadLogs(String instance_id){
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue(INSTANCE_ID, instance_id, Types.VARCHAR);
        try{
            return (List<Logs>) namedParameterJdbcTemplate.queryForObject(LogsConstants.query, sqlParameterSource, new LogsMapper());

        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
}
