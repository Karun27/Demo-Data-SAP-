package com.example.demo.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class LogsService {

    @Autowired
    private LogsRepository logsRepository;
    @Autowired
    private UniqLogsRepository uniqLogsRepository;
    @Autowired
    private JobNameRepository jobNameRepository;


    public List<Logs> list1(String instance_id) {
        return logsRepository.getLogs(instance_id);
    }
    public List<Logs> list(){
        return logsRepository.findAll();
    }

    public List<UniqLogs> loadUniq() {
    return uniqLogsRepository.getUniq();
    }

    public List<JobName> getJobName() {
        return jobNameRepository.getJobName();
    }

    public List<UniqLogs> getFilter(String job_Name,String status,  Date startDate, Date endDate) {
        return uniqLogsRepository.getFilter( job_Name,status, startDate, endDate);
    }

    public List<UniqLogs> statusOrder(String status) {
        return uniqLogsRepository.getStatus(status);
    }
}
