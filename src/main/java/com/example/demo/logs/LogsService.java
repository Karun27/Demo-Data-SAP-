package com.example.demo.logs;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getJobName() {
        return jobNameRepository.getJobName();
    }

    public List<UniqLogs> getFilter(String job_Name,String[] status, Date startDate, Date endDate) {
        System.out.println(Arrays.toString(status));
        String join = "'" + StringUtils.join(status,"','") + "'";
        System.out.println(join);

        if(join.contains("In Progress")){
            return uniqLogsRepository.getInProgress();
        }else if(!join.contains("In Progress") && join.length()==2) {
            return uniqLogsRepository.getFilter(job_Name, status, startDate, endDate);
        }
        return uniqLogsRepository.getFilter(job_Name, status, startDate, endDate);
    }

    public List<UniqLogs> statusOrder(String[] status) {

        if(Arrays.asList(status).contains("In Progress")){
            return uniqLogsRepository.getInProgress();
        }
        else {
            return uniqLogsRepository.getStatus(status);
        }
    }

    public void durationUpdate() {
        uniqLogsRepository.getUpdateDuration();
    }

    public void updateDuration() {
        uniqLogsRepository.getFinishedDuration();
    }

    public UniqLogs getEvent(BigInteger event_id) {
        return uniqLogsRepository.getOne(event_id);
    }
}
