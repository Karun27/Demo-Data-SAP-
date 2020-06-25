package com.example.demo.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface LogsRepository extends JpaRepository<Logs, BigInteger> {
//    @Transactional
//    @Query(value = "IF NOT EXISTS (select * from dbo.logs l where l.INSTANCE_ID = :instance_id)\n" +
//            "BEGIN \n" +
//            "\tINSERT INTO dbo.LOGS ( DATED, INSTANCE_ID ,MESSAGE, JOB_NAME) SELECT DATEADD(second, timestmp /1000 + 8*60*60, '19700101'),\n" +
//            "\tSUBSTRING(le.formatted_message ,CHARINDEX('-',le.formatted_message )+1,CHARINDEX('-',le.formatted_message )) ,\n" +
//            "\tSubstring(le.formatted_message, CHARINDEX('-',le.formatted_message,  CHARINDEX('-',le.formatted_message)+1)+1 ,Datalength(le.formatted_message)),\n" +
//            "\tSUBSTRING(le.formatted_message,0, CHARINDEX('-',le.formatted_message)) \n" +
//            "\tFROM dbo.logging_event le where DATEADD(second, le.timestmp /1000 + 8*60*60, '19700101') NOT IN (Select l.dated from dbo.LOGS l )\n" +
//            "END\n" +
//            "BEGIN\n" +
//            "\tselect * from dbo.LOGS l where l.instance_id = :instance_id\n" +
//            "END", nativeQuery = true)
//    List<Logs> getLogs(@Param("instance_id") String instance_id);

    @Transactional
    @Query(value = "select * from dbo.LOGS l where l.instance_id = :instance_id", nativeQuery = true)
    List<Logs> getLogs(@Param("instance_id") String instance_id);

    @Transactional
    @Query(value = "INSERT INTO LOGS( DATED, INSTANCE_ID ,MESSAGE, JOB_NAME) SELECT DATEADD(second, timestmp /1000 + 8*60*60, '19700101'),\n" +
            "SUBSTRING(formatted_message ,CHARINDEX('-',formatted_message )+1,CHARINDEX('-',formatted_message )) ,\n" +
            "Substring(formatted_message, CHARINDEX('-',formatted_message,  CHARINDEX('-',formatted_message)+1)+1 ,Datalength(formatted_message)),\n" +
            "SUBSTRING(formatted_message,0, CHARINDEX('-',formatted_message)) \n" +
            "FROM logging_event where DATEADD(second, timestmp /1000 + 8*60*60, '19700101') NOT IN (Select dated from LOGS )", nativeQuery = true)
    void loadLogs();

    @Transactional
    @Query(value="Select * \n" +
            "from dbo.LOGS l GROUP BY l.INSTANCE_ID, l.JOB_NAME", nativeQuery = true)
    List<UniqLogs> getUniq();
}