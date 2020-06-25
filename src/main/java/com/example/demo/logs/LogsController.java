package com.example.demo.logs;

import com.example.demo.data.TopicController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.DefaultValue;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogsController {

    Logger logger = LoggerFactory.getLogger(LogsController.class);
    @Autowired
    private LogsService logsService;

    @Autowired
    private DurationRepository durationRepository;

    @RequestMapping("/final")
    public List<Duration> getLogsDuration(){
        return durationRepository.getDuration();
    }

    @GetMapping("/instance/{Instance_id}")
    public List<Logs> fulllogList(@PathVariable String Instance_id) {
        logger.trace("FINISHED@0MAT_PLANT_ATTR!jobname*5eda72059ff7a66854f1d12b%Retrieving all topics : Started ");
        return logsService.list1(Instance_id);
    }

    //    @GetMapping("/load")
//    public void loadloglist(){
//        logsService.loadlogslist();
//    }
//    @GetMapping("/load")
//    public List<UniqLogs> loadUnique() {
//        logger.trace("Started@0MAT_PLANT_ATTR!jobname*123%Retrieving all topics : Started ");
//        logger.trace("Scheduled@0MAT_PLANT_ATTR!jobname*123%Retrieving all topics : Started ");
//        logger.trace("Initiated@0MAT_PLANT_ATTR!jobname*123%Retrieving all topics : Started ");
//        logger.trace("Started@TEST_JOB!jobname*456%Retrieving all topics : Started ");
//        logger.trace("Started@TEST_JOB!jobname*789%Retrieving all topics : Started ");
//        return logsService.loadUniq();
//    }

    @GetMapping("/load")
    public List<UniqLogs> loadUnique() {
        logger.trace("Started@0MAT_PLANT_ATTR!jobname*123%Retrieving all topics : Started ");
        logger.trace("Scheduled@0MAT_PLANT_ATTR!jobname*123%Retrieving all topics : Started ");
        logger.trace("Initiated@0MAT_PLANT_ATTR!jobname*123%Retrieving all topics : Started ");
        logger.trace("Started@TEST_JOB!jobname*456%Retrieving all topics : Started ");
        logger.trace("Started@TEST_JOB!jobname*789%Retrieving all topics : Started ");
        return logsService.loadUniq();
    }

//    @GetMapping("/job_Name/{job_Name}/status/{status}/startDate/{startDate}/endDate/{endDate}")
//    public List<FilterLogs> loadStatus( @PathVariable String job_Name, @PathVariable String status, @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date startDate, @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
//        return logsService.status(job_Name,status,startDate,endDate);
//    }

    @GetMapping("/job_Name/{job_Name}/status/{status}/date/{startDate}/end/{endDate}")
    public List<UniqLogs> filterLoad( @PathVariable String job_Name,@PathVariable String status, @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,  @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return logsService.getFilter(job_Name,status,startDate,endDate);
    }

    @GetMapping("/jobname")
    public List<JobName> jobName(){
        return logsService.getJobName();
    }

    @GetMapping("/test")
    public List<StartLogs> loadTest(){
        return logsService.testLoad();
    }

//    @GetMapping("/duration")
//    public List<UniqLogs> loadDuration(){
//        return logsService.loadDuration();
//    }
    @GetMapping("/")
    public List<Logs> fulllogs() {
        return logsService.list();
    }
}
