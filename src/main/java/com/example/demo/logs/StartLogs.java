package com.example.demo.logs;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOGS")
public class StartLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="INSTANCE_ID")
    private String instance_id;

    @Column(name="STARTTIME")
    @JsonSerialize(using= CustomStartTimeSerializer.class)
    private Date startTime;


    public String getInstance_id() {
        return instance_id;
    }

    public void setInstance_id(String instance_id) {
        this.instance_id = instance_id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
