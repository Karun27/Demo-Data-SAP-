package com.example.demo.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogsController {

    @Autowired
    private LogsService logsService;

    @GetMapping("/instance/{Instance_id}")
    public List<Logs> fulllogList(@PathVariable String Instance_id) {
        return logsService.list1(Instance_id);
    }

    @GetMapping("/load")
    public List<UniqLogs> loadUnique() {
        return logsService.loadUniq();
    }

    @GetMapping("/job_Name/{job_Name}/status/{status}/date/{startDate}/end/{endDate}")
    public List<UniqLogs> filterLoad( @PathVariable String job_Name,@PathVariable String[] status, @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,  @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return logsService.getFilter(job_Name,status,startDate,endDate);
    }

    @GetMapping("/event/{event_id}")
    public UniqLogs getEvent(@PathVariable BigInteger event_id){
        return logsService.getEvent(event_id);
    }

    @GetMapping("/status/{status}")
    public List<UniqLogs> getStatus(@PathVariable String[] status){
        return logsService.statusOrder(status);
    }
    @GetMapping("/jobname")
    public List<String> jobName(){
        return logsService.getJobName();
    }

    @GetMapping("/update")
    public void updateTime(){
        logsService.durationUpdate();
    }

    @GetMapping("/updateFinished")
    public void updateFinishedTime(){
        logsService.updateDuration();
    }

    @GetMapping("/")
    public List<Logs> fulllogs() {
        return logsService.list();
    }
}
