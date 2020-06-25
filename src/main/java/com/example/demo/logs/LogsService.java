package com.example.demo.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class LogsService {

    Logger logger = LoggerFactory.getLogger(LogsService.class);
    @Autowired
    private LogsRepository logsRepository;
    @Autowired
    private UniqLogsRepository uniqLogsRepository;

    @Autowired
    private StartLogsRepository startLogsRepository;

    @Autowired
    private JobNameRepository jobNameRepository;

//    @Autowired
//    private DurationRepositoryCustom durationRepositoryCustom;

    public List<Logs> list1(String instance_id) {
        logger.trace("FINISHED@0MAT_PLANT_ATTR!jobname*5eda72059ff7a66854f1d12b%Job execution : Completed ");
        return logsRepository.getLogs(instance_id);
//        return loadLogsRepository.loadLogs(instance_id);
    }
    public List<Logs> list(){
        return logsRepository.findAll();
    }

    public List<UniqLogs> loadUniq() {
        logger.trace("FINISHED@0MAT_PLANT_ATTR!jobname*123%Job execution : Completed ");
        logger.trace("FINISHEd@TEST_JOB!jobname*456%Job execution : Completed ");
        logger.trace("FINISHED@CUST_DATA!jobname*789%Job execution : Completed ");

        return uniqLogsRepository.getUniq();
    }

//    public List<FilterLogs> status(String status, String job_Name, Date startDate,  Date endDate) {
//        return uniqLogsRepository.getStatus(status, job_Name, startDate, endDate);
//    }

    public List<StartLogs> testLoad() {
        return startLogsRepository.getTest();
    }

    public List<JobName> getJobName() {
        return jobNameRepository.getJobName();
    }

    public List<UniqLogs> getFilter(String job_Name,String status,  Date startDate, Date endDate) {
        return uniqLogsRepository.getFilter( job_Name,status, startDate, endDate);
    }

//    public List<UniqLogs> loadDuration() {
//        return durationRepositoryCustom.getDuration();
//    }


//
//    public void loadlogslist() {
//        logsRepository.loadLogs();
//    }
}
