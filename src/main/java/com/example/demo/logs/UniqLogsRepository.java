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
@Query(value = "select l1.INSTANCE_ID, l1.starttime, l2.status, l1.JOB_NAME, l1.job_id, l1.startdate, l1.dated, l1.event_id, l1.duration, l1.enddate from logs l1 join logs l2 on l1.INSTANCE_ID=l2.INSTANCE_ID where l1.status='Initiated' \n" +
        "and l2.status in ('Finished', 'Cancelled')", nativeQuery = true)
    List<UniqLogs> getUniq();
@Transactional
@Query(value = "select l1.INSTANCE_ID, l1.starttime, l2.status, l1.JOB_NAME, l1.job_id, l1.startdate, l1.enddate, l1.dated, l1.event_id, l1.duration from logs l1 join logs l2 on l1.INSTANCE_ID=l2.INSTANCE_ID where l1.status='Initiated' \n" +
        "and l2.status = :status and l2.job_name like '%'+:job_Name+'%' and l2.startdate >= :startDate and l2.endDate <= :endDate", nativeQuery = true)
    List<UniqLogs> getFilter(@Param("job_Name") String job_Name, @Param("status") String status, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

@Transactional
@Query(value = "select l1.INSTANCE_ID, l1.starttime, l2.status, l1.JOB_NAME, l1.job_id, l1.startdate, l1.dated, l1.event_id, l1.duration, l1.enddate from logs l1 join logs l2 on l1.INSTANCE_ID=l2.INSTANCE_ID where l1.status='Initiated' \n" +
        "and l2.status = :status", nativeQuery = true)
    List<UniqLogs> getStatus(@Param("status")String status);
}