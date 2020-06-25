package com.example.demo.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface UniqLogsRepository extends JpaRepository<UniqLogs, BigInteger> {


    @Transactional
    @Query(value = "select l.event_id, l.dated, l.instance_id, l.message, l.job_name from dbo.LOGS l where l.instance_id = :instance_id", nativeQuery = true)
    List<Logs> getLogs(@Param("instance_id") String instance_id);

    @Transactional
    @Query(value = "INSERT INTO LOGS( DATED, INSTANCE_ID ,MESSAGE, JOB_NAME) SELECT DATEADD(second, timestmp /1000 + 8*60*60, '19700101'),\n" +
            "SUBSTRING(formatted_message ,CHARINDEX('-',formatted_message )+1,CHARINDEX('-',formatted_message )) ,\n" +
            "Substring(formatted_message, CHARINDEX('-',formatted_message,  CHARINDEX('-',formatted_message)+1)+1 ,Datalength(formatted_message)),\n" +
            "SUBSTRING(formatted_message,0, CHARINDEX('-',formatted_message)) \n" +
            "FROM logging_event where DATEADD(second, timestmp /1000 + 8*60*60, '19700101') NOT IN (Select dated from LOGS )", nativeQuery = true)
    void loadLogs();

//    @Transactional
//    @Query(value="Select l.INSTANCE_ID, l.JOB_NAME, l.JOB_ID, l.event_id, l.dated \n" +
//            "from dbo.LOGS l GROUP BY l.INSTANCE_ID, l.JOB_NAME, l.JOB_ID, l.event_id, l.dated", nativeQuery = true)
//    List<UniqLogs> getUniq();

    @Transactional
//    @Query(value="Select * \n" +
//            "from dbo.LOGS l where l.status = 'FINISHED'", nativeQuery = true)
    @Query(value= "select l1.INSTANCE_ID, l1.starttime, l2.status, l1.JOB_NAME, l1.job_id, l1.startdate, l1.dated, l1.event_id, l1.duration, l1.enddate from logs l1 join logs l2 on l1.INSTANCE_ID=l2.INSTANCE_ID where l1.status='Initiated' \n" +
            "and l2.status in ('Finished', 'Cancelled')", nativeQuery = true)
    List<UniqLogs> getUniq();

//    @Transactional
//    @Query(value= "select l1.INSTANCE_ID, l1.starttime, l2.status, l1.JOB_NAME, l1.job_id, l1.startdate, l1.enddate, l1.dated, l1.event_id, l1.duration from logs l1 join logs l2 on l1.INSTANCE_ID=l2.INSTANCE_ID where l1.status='Started' \n" +
//            "and l2.status = :status and l2.JOB_NAME = :job_Name and l2.startdate = :startDate and l2.enddate = :endDate", nativeQuery = true)
//    List<FilterLogs> getStatus(@Param("status") String status, @Param("job_Name") String job_Name, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Transactional
    @Query(value="Select INSTANCE_ID, min(starttime) from LOGS l group by INSTANCE_ID", nativeQuery = true)
    List<StartLogs> getTest();

//    @Transactional
//    @Query(value="select * from dbo.logs l where l.status= :status and l.job_id= :job_id and l.startdate = :startDate and l.enddate = :endDate", nativeQuery = true)
//    List<UniqLogs> getFilter(@Param("status") String status, @Param("job_id") String job_id, @Param("startDate")Date startDate, @Param("endDate")Date endDate);
@Transactional
@Query(value= "select l1.INSTANCE_ID, l1.starttime, l2.status, l1.JOB_NAME, l1.job_id, l1.startdate, l1.enddate, l1.dated, l1.event_id, l1.duration from logs l1 join logs l2 on l1.INSTANCE_ID=l2.INSTANCE_ID where l1.status='Initiated' \n" +
        "and l2.status = :status and l2.job_name = :job_Name and l2.startdate = :startDate and l2.endDate = :endDate", nativeQuery = true)
List<UniqLogs> getFilter( @Param("job_Name") String job_Name, @Param("status") String status, @Param("startDate")Date startDate, @Param("endDate")Date endDate);
}