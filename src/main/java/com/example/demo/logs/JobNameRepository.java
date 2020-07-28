package com.example.demo.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface JobNameRepository extends JpaRepository<UniqLogs, String> {

    @Transactional
    @Query(value = "select DISTINCT l.job_name from dbo.LOGS l ", nativeQuery = true)
    List<String> getJobName();

}